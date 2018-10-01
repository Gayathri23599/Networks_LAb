import java.io.*;
import java.net.*;
public class server_snmp{
	public static void main(String[] args)throws Exception{
		DatagramSocket server = new DatagramSocket(5000);
		byte[] data = new byte[1024];
		while(true){
			DatagramPacket rcv = new DatagramPacket(data,data.length);
			server.receive(rcv);
			String s = new String(rcv.getData());
			System.out.println(s);
		}
	}
}
