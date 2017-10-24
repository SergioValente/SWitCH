package aula03_17102017;


import java.io.*;

public class Cliente {

	private DataOutputStream outS;
	
	public Cliente(DataOutputStream outS) {
		this.outS = outS;
	}

	public DataOutputStream getOutS() {
		return outS;
	}
}

