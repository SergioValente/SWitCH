package aula03_17102017;

import java.io.*;
import java.net.*;

public class ThreadCliente implements Runnable {

	private Socket clisock;
	
	//construtor
	public ThreadCliente (Socket s) {
		clisock = s;
	}

	public void run() {
		
		String nickname;
		try {
			DataOutputStream outS = new DataOutputStream(clisock.getOutputStream());
			DataInputStream inS = new DataInputStream(clisock.getInputStream());
			
			//registo do cliente (aceitação ou não do nickname)
			while(true) {
				Mensagem message = new Mensagem(inS);
				
				if (message.erro()) {
					clisock.close();
					return;
				}
				
				if (message.estaVazia()) {
					message.enviar(outS);
					clisock.close();
					return;
				}
				nickname = message.comoString();
				if (ListaClientes.adicionar(nickname, outS)) break;
				
				Mensagem ko = new Mensagem ("KO");
				ko.enviar(outS);
			}
			
			Mensagem ok = new Mensagem ("OK");
			ok.enviar(outS);
			
			// cliente registado (nickname aceite)
			while(true) {
				Mensagem message = new Mensagem(inS);
				
				if (message.erro()) {
					ListaClientes.remover(nickname);
					clisock.close();
					return;
				}
				
				if (message.estaVazia()) {
					message.enviar(outS);
					ListaClientes.remover(nickname);
					clisock.close();
					return;
				}
				
				if (!(message.eComando())) { //se a mensagem não é comando
					Mensagem cn = new Mensagem("[" + nickname + "] " + message.comoString());
					ListaClientes.enviarParaTodos(cn);
				}
				else {
					
				}
			}
		}
		catch (IOException e) {
			try {clisock.close();} catch (IOException ex) {};
			return;
		}
	}
}
