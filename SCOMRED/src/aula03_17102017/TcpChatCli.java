package aula03_17102017;

import java.io.*;
import java.net.*;

public class TcpChatCli {

	static final int DEF_PORT = 8099;
	
	public static void main(String[] args) throws IOException {
		
		String serverName = null;
		String nickname;
		String frase;
		InetAddress ServerIP;
		Socket ss;
		DataOutputStream outS;
		DataInputStream inS;
		Mensagem resposta;
		Mensagem m;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
		try {
			System.out.print("Indique o endereço do servidor ou nome DNS: ");
			serverName = in.readLine();
			ServerIP = InetAddress.getByName(serverName);
			ss = new Socket(ServerIP, DEF_PORT);
			outS = new DataOutputStream(ss.getOutputStream());
		    inS = new DataInputStream(ss.getInputStream());
		    do {
		    		System.out.print("Indique o nickname (vazio para desistir): ");
				nickname = in.readLine();
				Mensagem message = new Mensagem (nickname);
				message.enviar(outS);
				resposta = new Mensagem(inS);
				if(resposta.comoString().equals("KO")) {
					System.out.println("Nickname em uso...");
				}
				if(resposta.estaVazia()) {
					ss.close();
					System.exit(0);
				}
		    } while (!resposta.comoString().equals("OK"));
		    
		    //cliente registado
		    System.out.println("Registado no servidor...");
		    System.out.println("Pode escrever. Frase vazia para sair.");
		    Thread th = new Thread(new ReaderThread(inS)); //recebe mensagens e imprime no ecrã
		    th.start();
		    
		    do {
		    		frase = in.readLine();
		    		m = new Mensagem(frase);
		    		m.enviar(outS);
		    		
		    } while (!m.estaVazia());
		    
		    System.out.println("Adeus Mundo!!!!");
		    try {
		    		th.join(); 
		    }
		    catch(InterruptedException e) {
		    		System.out.println(e.getMessage());
		    }
		    
		}
		catch (IOException e) {
			System.out.println("Erro fatal: " + e.getMessage());
			System.exit(1);
		}
		
		
	}
	
}
