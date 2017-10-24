package aula03_17102017;

import java.util.*;
import java.io.*;

public class ListaClientes {
	//Todos os métodos serão synchronized pois é preciso garantir que não há mais threads a mexer na lista
	private static HashMap<String, Cliente> listaClientes = new HashMap<>();
	
	public static synchronized boolean adicionar(String nick, DataOutputStream outS) {
		
		if (listaClientes.containsKey(nick)) return false;
		Cliente cli = new Cliente(outS);
		listaClientes.put(nick, cli);
		return true;
	}
	
	public static synchronized boolean remover(String nick) {
		
		//if (!(listaClientes.containsKey(nick))) return false; linha desnecessária
		
		return(listaClientes.remove(nick) != null);
		
	}
	
	public static synchronized void enviarParaTodos(Mensagem message) {
		
		for (Cliente c: listaClientes.values()) {
			message.enviar(c.getOutS());
		}	
	}
}
