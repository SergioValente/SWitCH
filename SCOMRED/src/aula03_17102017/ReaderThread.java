package aula03_17102017;

import java.io.DataInputStream;

public class ReaderThread extends Thread {

	private DataInputStream inS;
	
	public ReaderThread (DataInputStream inS) {
		this.inS = inS;
	}
	
	@Override
	public void run() {
		
		Mensagem m;
		
		do {
			m = new Mensagem(inS);
			System.out.println(m.comoString());
			
		} while (!m.estaVazia());
	}
}
