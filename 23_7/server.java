import java.io.*;
import java.net.*;
import java.util.*;
class server{
	public static void main(String args[])throws Exception{
		DatagramSocket server = new DatagramSocket(1234);
		while(true){
			byte[] sendByte = new byte[1024];
			byte[] receiveByte = new byte[1024];
			DatagramPacket receiver = new DatagramPacket(receiveByte,receiveByte.length);
			server.receive(receiver);
			String str = new String(receiver.getData());
			str = str.trim();
			InetAddress addr = receiver.getAddress();
			int port = receiver.getPort();
			String ip[] = {"255.255.255.255","192.168.1.1"};
			String name[] = {"www.gfg.com","www.fb.com"};
			for(int i = 0;i<2;i++){
				if(str.equals(ip[i])){
					sendByte = name[i].getBytes();
					break;
				}
				else if(str.equals(name[i])){
					sendByte = ip[i].getBytes();
					break;
				}
			}
			DatagramPacket sender = new DatagramPacket(sendByte,sendByte.length,addr,port);
			server.send(sender);
			break;
		}
	}
}
