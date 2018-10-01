import java.io.*;
import java.net.*;
public class snmp_server{
	public static void main(String[] args) throws Exception{
		DatagramSocket server = new DatagramSocket(5000);
		System.out.println("ALERT!!");
		System.out.println();
		System.out.println("Below are the disks which got used 50% of its space");
		while(true){
			byte[] r = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(r,r.length);
			server.receive(receivePacket);
			String sen = new String(receivePacket.getData());
			System.out.println(sen);
		}
	}
}
