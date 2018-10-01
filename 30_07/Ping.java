import java.io.*;
import java.net.*;
class Ping{
	public static void sendPingRequest(String ipAddress) throws Exception{
		InetAddress addr = InetAddress.getByName(ipAddress);
		System.out.println("Sending ping request to " + ipAddress);
		if(addr.isReachable(5000))
			System.out.println("Host is reachable");
		else
			System.out.println("Sorry! We can't reach this host");
	}
	public static void main(String[] args)throws Exception{
		String ipAddress = "8.8.8.8";
		sendPingRequest(ipAddress);
	}
}
