import java.io.*;
import java.net.*;
public class quad{
	public static void main(String args[]) throws Exception{
		try{
		Socket socket = new Socket("localhost",5080);
		BufferedReader outFromClient = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String sentence = inFromServer.readLine();
		System.out.println(sentence);
		String a = outFromClient.readLine();
		outToServer.writeBytes(a + '\n');
		System.out.println("Enter b:");
		String b = outFromClient.readLine();
		outToServer.writeBytes(b + '\n');
		System.out.println("Enter c:");
		String c = outFromClient.readLine();
		outToServer.writeBytes(c + '\n');
		String ans = inFromServer.readLine();
		System.out.println("SOLUTION: " + ans);
		socket.close();
		}
		catch(Exception e){
			System.out.println("error");
		}
	}
}
