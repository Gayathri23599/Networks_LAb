import java.io.*;
import java.net.*;
public class client{
	public static void main(String argv[]) throws Exception{
		String sentence,modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new 
	InputStreamReader(System.in));
		while(true){
			Socket clientSocket = new Socket("localhost",2222);
			DataOutputStream outToServer = new DataOutputStream(
		clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new 
		InputStreamReader(clientSocket.getInputStream()));
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("From Server:"+modifiedSentence);
			clientSocket.close();
		}
	}
}
