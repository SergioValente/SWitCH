package aula05_31102017;

import java.io.*;
import java.net.*;

public class HTTPClient extends Thread{

	private Socket cliS;
	private DataOutputStream out;
	private DataInputStream in;
	
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
			if (!requestComponents[0].equals("GET")) return;	//GET, não Get!!!!!!
			
			if (requestComponents[1].contentEquals("/")) {
				sendForm();
			}
				
			
			
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
		String form = "<html><head><title>WebMultiplos</title><head>";
		form += "<body bgcolor=c0c0c0><h1>WebMultiplos</h1>";
		form += "<h3>Cálculo de múltiplos de 2, 3, 5 e 7 no intervalo [a, b]</h3>";
		form += "<form action=/calcula method=GET>";
		form += "A: <input type=text name=A value=1>";
		form += "B: <input type=text name=B value=100>";
		form += "<input type=submit value=CALCULAR>";
		form += "</form></body></html>";
		sendHTMLContent(form);
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
	
}
