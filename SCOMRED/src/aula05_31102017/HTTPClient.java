package aula05_31102017;

import java.io.*;
import java.net.*;

public class HTTPClient extends Thread{

	private Socket cliS;
	private DataOutputStream out;
	private DataInputStream in;
	
	private final String HTML_HEAD = "<html><head><title>WebMultiplos</title><head>" +
	"<body bgcolor=c0c0c0><h1>WebMultiplos</h1>";
	
	private final String HTML_TAIL = "<hr><p><a href=/>Regressar ao formulário</a>" +  
	"<p><a href=/status>Status</a></p>" + 
	"<p><a href=/close>Terminar Aplicação</a></p>" + "</body></html>";
	
	public HTTPClient(Socket s) {
		this.cliS = s;
	}
	
	@Override
	public void run() {
		
		try {
			out = new DataOutputStream(cliS.getOutputStream());
			in = new DataInputStream(cliS.getInputStream());
			
			String requestLine = readLineHTTP();
			String headerLine;
			do {
				headerLine = readLineHTTP();
			} while (!headerLine.isEmpty());
			
			String[] requestComponents = requestLine.split(" ");
			if (!requestComponents[0].equals("GET")) { //GET, não Get!!!!!!
				sendNotImplemented();	
			}	
			
			else if (requestComponents[1].contentEquals("/")) {
				sendForm();
			}
			
			else if(requestComponents[1].startsWith("/calcula")) {
				calcula(requestComponents[1]);
			}
			
			else if (requestComponents[1].contentEquals("/status")) {
				sendStatus();	
			}
			else if (requestComponents[1].contentEquals("/close")) {
				close();
			}
			else sendNotFound(); 
			
		}
		catch(IOException ioe) {
			System.out.println("Erro de IO: " + ioe.getMessage());
			return;
		}
	}
	
	private final int CR = 13;
	private final int LF = 10;
	private String readLineHTTP() throws IOException {
		int val;
		String ret = "";
		do {
			val = in.read();
			if (val != CR) ret = ret + (char) val; 
		} while (val != CR);
		in.read(); //para ler o último line feed
		return ret;
	}
	
	private void writeLineHTTP(String line) throws IOException {
		
		out.write(line.getBytes(),0,line.length());
		out.write(CR);
		out.write(LF);
	}
	
	private void sendForm() throws IOException{
		String form = HTML_HEAD;
		form += "<h3>Cálculo de múltiplos de 2, 3, 5 e 7 no intervalo [a, b]</h3>";
		form += "<form action=/calcula method=GET>";
		form += "A: <input type=text name=A value=1>";
		form += "B: <input type=text name=B value=100>";
		form += "<input type=submit value=CALCULAR></form>";
		form += HTML_TAIL;
		sendHTMLContent(form);
	}
	
	private void sendInvalidData() throws IOException {
		String content = HTML_HEAD + "<h2>Os dados fornecidos são inválidos.</h2>" + HTML_TAIL;
		sendHTMLContent(content);
	}
	
	private void sendHTMLContent(String content) throws IOException{
		
		byte[] bCont = content.getBytes();
		writeLineHTTP("HTTP/1.0 200 OK");
		writeLineHTTP("Content-type: text/html; charset=UTF8");
		writeLineHTTP("Content-length: " + bCont.length);
		writeLineHTTP("Connection: close");
		writeLineHTTP(""); //termina com uma linha vazia!!!
		out.write(bCont, 0, bCont.length);
	}
	
	private void sendNotFound() throws IOException{
		
		String content = HTML_HEAD + "<h3>Endereço Inválido.</h3>" + HTML_TAIL;
		
		byte[] bCont = content.getBytes();
		writeLineHTTP("HTTP/1.0 404 Not Found");
		writeLineHTTP("Content-type: text/html; charset=UTF8");
		writeLineHTTP("Content-length: " + bCont.length);
		writeLineHTTP("Connection: close");
		writeLineHTTP(""); //termina com uma linha vazia!!!
		out.write(bCont, 0, bCont.length);
	}
	
	private void sendNotImplemented() throws IOException{
		
		String content = HTML_HEAD + "<h3>Operação não suportada.</h3>" + HTML_TAIL;
		
		byte[] bCont = content.getBytes();
		writeLineHTTP("HTTP/1.0 501 Method Not Implemented");
		writeLineHTTP("Content-type: text/html; charset=UTF8");
		writeLineHTTP("Content-length: " + bCont.length);
		writeLineHTTP("Connection: close");
		writeLineHTTP(""); //termina com uma linha vazia!!!
		out.write(bCont, 0, bCont.length);
	}
	
	private void sendStatus() throws IOException{
		
		String content = HTML_HEAD + 
				"<h3>Número de pedidos HTTP recebidos: </h3>" + 
				WebMultiplos.getNumConnetions() + 
				"<hr>Endereço do Cliente: " +
				cliS.getInetAddress().getLocalHost() + " : " + 
				cliS.getPort() + HTML_TAIL;
		
		sendHTMLContent(content);
	}
	
	private void close() throws IOException{
		
		String content = HTML_HEAD + 
				"<h3>Aplicação terminada. </h3>";
		
		sendHTMLContent(content);
		System.exit(0);
	}

	//uri = /calcula?A=valor1&B=valor2
	private void calcula(String uri) throws IOException{
		
		String[] args = uri.split("=");
		if (args.length != 3) sendInvalidData();
		String valor2 = args[2];
		String valor1 = args[1].substring(0, args[1].length() - 2);
		int v1 = 0;
		int v2 = 0;
		try {
			v1 = Integer.parseInt(valor1);
			v2 = Integer.parseInt(valor2);
		}
		catch(NumberFormatException ne) {
			sendInvalidData();
		}
		
		String content = HTML_HEAD;
		if(v1 > v2) {
			int aux = v1;
			v1 = v2;
			v2 = aux;
			content = content + "<p>Os limites do intervalo foram trocados.</p>";
		}
		
		if (v1 < 0) { //Só números positivos, de acordo com os requisitos
			sendInvalidData();
			return;
		}
		String[] multiplos = new String[4];
		for (int i = 0; i < 4; i++) {
			multiplos[i] = "";
		}
		int[] divisores = {2,3,5,7};
		for(int i = v1; i <= v2; i++) {
			for (int d = 0; d < 4; d++) {
				if(i % divisores[d] == 0)
					multiplos[d] = multiplos[d] + i + " ; ";
			}
		}
		content = content + "<h3>Múltiplos de 2, 3, 5 e 7 no intervalo fechado [" + v1 + ", " + v2 + "]</h3><hr>";
		
		for(int d = 0; d < 4; d++) {
			content = content + "<p><b>Múltiplos de " + divisores[d] + ": </b>" + multiplos[d] + "</p><hr>";
		}
		content = content + HTML_TAIL;
		sendHTMLContent(content);
		
	}
}
