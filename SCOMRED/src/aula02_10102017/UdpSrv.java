

package aula02_10102017;
import java.io.*; 
import java.net.*; 
/**
 *
 * @author SCOMRED
 */
public class UdpSrv {

    static DatagramSocket sock;
    static final int SERVER_PORT=9999;
    
    public static void main(String[] args) throws IOException {

        byte[] data = new byte[300];
        byte[] data1 = new byte[300];
        int i, len;

        try { sock = new DatagramSocket(SERVER_PORT); }
        catch(BindException ex) {
                System.out.println("O porto local " + SERVER_PORT + " está ocupado.");
                System.exit(1);
                }

        DatagramPacket udpPacket= new DatagramPacket(data, data.length);

        System.out.println("A aguardar pedidos dos clientes. Este servidor nunca termina.");
        while(true) {
            udpPacket.setData(data);
            udpPacket.setLength(data.length);
            sock.receive(udpPacket); // WAIT FOR A REQUEST
            len=udpPacket.getLength();
            System.out.println("Pedido proveniente de: " + udpPacket.getAddress().getHostAddress() +
                        " porto: " + udpPacket.getPort());
            for(i=0;i<len;i++) data1[len-1-i]=data[i];
            udpPacket.setData(data1);
            udpPacket.setLength(len);
            sock.send(udpPacket); // SEND THE REPLY - to the request source address
            }
        }
    }
