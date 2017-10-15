

package aula02_10102017;

import java.io.*; 
import java.net.*; 

/**
 *
 * @author SCOMRED
 */
public class UdpCli {
    
    static InetAddress IPdestino;
    static final int SERVER_PORT=9999;
    
    public static void main(String[] args) throws IOException {
 
        byte[] data = new byte[300];
        String frase=null;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Indique o endereço do servidor ou nome DNS: ");
        frase = in.readLine();

        try { IPdestino = InetAddress.getByName(frase); }
        catch(UnknownHostException ex) {
            System.out.println("O endereço/nome não é válido: "  + frase);
            System.exit(1);
	} 

        DatagramSocket sock = new DatagramSocket();
        sock.setSoTimeout(1000);
         
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
            		sock.receive(udpPacket); 
            		frase = new String( udpPacket.getData(), 0, udpPacket.getLength());
            		System.out.println("Resposta recebida do servidor: " + frase); 
            		}
            catch(SocketTimeoutException e) 
            	{
            		System.out.println("A operação falhou. Tempo expirou.");
            	}
        }
        sock.close();
        }
    
    }
