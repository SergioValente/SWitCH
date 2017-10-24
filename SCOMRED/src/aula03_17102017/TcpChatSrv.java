package aula03_17102017;

import java.io.*;
import java.net.*;

public class TcpChatSrv {

	private static final int DEF_PORT = 8099;
	
	public static void main(String[] args) {
		
		ServerSocket ss;
		Socket cs; 
		
		try {
			ss = new ServerSocket(DEF_PORT); 

			while(true) {
				cs = ss.accept(); //aceita pedidos de ligação de clientes
				Thread th = new Thread (new ThreadCliente(cs)); //cria nova thread
				th.start();	//inicia nova thread
			}
		}
		catch (IOException e) {
			System.out.println("Erro fatal: " + e.getMessage());
			System.exit(1);
		}
	}
}
