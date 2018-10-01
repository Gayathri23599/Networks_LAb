import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
public class client_snmp{
	public static void main(String[] args)throws Exception{
		System.out.println("Enter a number");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		Random r = new Random();
		int mul = r.nextInt(2);
		if((num*mul) == 0 || (num*mul) == 1){
			DatagramSocket client = new DatagramSocket();
			InetAddress IP = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			String sentence = "Alert!";
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IP,5000);
			client.send(sendPacket);
			System.out.println("Since you got " + (num*mul) + "as result");
			client.close();
		}
		else
			System.out.println("You got" + (num*mul));
	}
}
