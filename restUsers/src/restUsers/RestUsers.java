package restUsers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RestUsers {

	public static void main(String[] args) {

		ServerSocket ss = null;
		Socket cs = null;
		try {
			ss = new ServerSocket(8085);
		}
		catch (IOException ioe) {
			System.out.println("Erro ao abrir o serverSocket: " + ioe.getMessage());
			System.exit(1);
		}

		while(true) {
			try {
				cs = ss.accept(); //aceita pedidos de ligação de clientes
				Thread th = new Thread (new HTTPProcessRequest(cs)); //cria nova thread
				th.start();	//inicia nova thread
			}
			catch(IOException ioe) {
				System.out.println("Erro ao aceitar conexão.");
			}
		}
	}
}
