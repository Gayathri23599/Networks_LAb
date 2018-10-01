import java.io.*;
import java.net.*;
import java.util.*;
class Server{
	public static void main(String[] args)throws Exception{
		DatagramSocket server = new DatagramSocket(1234);
		while(true){
			byte[] sendByte = new byte[1024];
			byte[] receiveByte = new byte[1024];
			DatagramPacket receiver = new DatagramPacket(receiveByte,receiveByte.length);
			server.receive(receiver);
			InetAddress addr = receiver.getAddress();
			int port = receiver.getPort();
			String s = new String(receiver.getData());
			s = s.trim();
			InetAddress opaddr = InetAddress.getByName(s);
			sendByte = opaddr.toString().getBytes();
			DatagramPacket sender = new DatagramPacket(sendByte,sendByte.length,addr,port);
			server.send(sender);
			break;
		}
	}
}
