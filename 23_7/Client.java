import java.io.*;
import java.net.*;
import java.util.*;
class Client{
	public static void main(String[] args)throws Exception{
		DatagramSocket client = new DatagramSocket();
		byte[] sendByte = new byte[1024];
		byte[] receiveByte = new byte[1024];
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		int port = 1234;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		sendByte = str.getBytes();	
		DatagramPacket sender = new DatagramPacket(sendByte,sendByte.length,addr,port);
		client.send(sender);
		DatagramPacket receiver = new DatagramPacket(receiveByte,receiveByte.length);
		client.receive(receiver);
		String s = new String(receiver.getData());
		System.out.println(s);
		client.close();
	}
}
