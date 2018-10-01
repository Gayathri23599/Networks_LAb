import java.io.*;
import java.net.*;
public class client_udp{
	public static void main(String argv[]) throws Exception{
		DatagramSocket socket = new DatagramSocket();
		while(true){
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			InetAddress add = InetAddress.getByName("localhost");
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,add,1234);
			socket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			socket.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("From Server:"+modifiedSentence);
			//socket.close();
		}
	}
}
