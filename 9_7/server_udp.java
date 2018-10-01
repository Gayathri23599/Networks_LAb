import java.io.*;
import java.net.*;
public class server_udp{
	public static void main(String argv[]) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(1234);
		while(true){	
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("Rcvd:"+sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String capitalizedSentence = input.readLine();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
			serverSocket.send(sendPacket);
		}
	}
}
