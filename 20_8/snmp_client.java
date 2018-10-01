import java.io.*;
import java.net.*;
public class snmp_client{
	public static void main(String[] args)throws Exception{
		String[] cmd = {"/bin/sh","-c","df | awk '{if(NR!=1 && int($5) > 0){print $1}}'"};
		Process p = Runtime.getRuntime().exec(cmd);
		String s = null;
		BufferedReader s1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
		DatagramSocket client = new DatagramSocket();
		InetAddress IP = InetAddress.getByName("localhost"); 
		while((s = s1.readLine()) != null){
			byte[] send = new byte[1024];
			send = s.getBytes();
			DatagramPacket sp = new DatagramPacket(send,send.length,IP,5000);
			client.send(sp);
		}
		client.close();
	}
}