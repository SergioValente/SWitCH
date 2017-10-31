package aula05_31102017;

import java.io.*;

import java.net.*;

public class WebMultiplos {

	public static void main(String[] args) {
		
		ServerSocket ss = null; 
		Socket cs = null;
		try {
			ss = new ServerSocket(8080); 
		}
		catch (IOException ioe) {
			System.out.println("Erro ao abrir o serverSocket: " + ioe.getMessage());
			System.exit(1);
		}
		
		while(true) {
			try {
				cs = ss.accept(); //aceita pedidos de ligação de clientes
				Thread th = new Thread (new HTTPClient(cs)); //cria nova thread
				th.start();	//inicia nova thread
			}
			catch(IOException ioe) {
				System.out.println("Erro ao aceitar conexão.");
			}
		}
	}
}
