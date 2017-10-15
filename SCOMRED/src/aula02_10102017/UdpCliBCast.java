package aula02_10102017;

import java.io.*; 
import java.net.*; 

/**
 *
 * @author SCOMRED
 */
public class UdpCliBCast {
    
    static InetAddress IPdestino;
    static final int SERVER_PORT=9999;
    
    public static void main(String[] args) throws IOException {
 
        byte[] data = new byte[300];
        InetAddress meuServidor = null;
        String frase=null;
        IPdestino = InetAddress.getByName("255.255.255.255");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket sock = new DatagramSocket();
        sock.setSoTimeout(2000);
        sock.setBroadcast(true);
         
        DatagramPacket udpPacket = new DatagramPacket(data, data.length, IPdestino, SERVER_PORT);

        while(true) {
            System.out.print("Frase a enviar (para terminar utilize sair): ");
            frase = in.readLine();
            if(frase.compareTo("sair")==0) break;
            udpPacket.setData(frase.getBytes());
            udpPacket.setLength(frase.length());
            sock.send(udpPacket);
            udpPacket.setData(data);
            udpPacket.setLength(data.length);
            
            try {
            		do {  //do while para eliminar as mensagens repetidas dos diferentes servidores.
            			sock.receive(udpPacket); 
            			if (meuServidor == null)
            				meuServidor = udpPacket.getAddress();
            		} while (udpPacket.getAddress() != meuServidor);
            		
            		frase = new String( udpPacket.getData(), 0, udpPacket.getLength());
            		System.out.println("Resposta recebida do servidor: " + frase);
            		}
            catch (SocketTimeoutException e) 
            {
            		System.out.println("A operação falhou. Tempo expirou.");
            	}           
        }
        sock.close();
        }
    
    }
