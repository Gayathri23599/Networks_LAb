import java.io.*;
import java.net.*;
import java.util.*;
public class server{
	public static void main(String argv[]) throws Exception{
		String clientSentence,capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(2222);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Rcvd:"+clientSentence);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//Scanner input = new Scanner(System.in);
			capitalizedSentence = input.readLine();
			//capitalizedSentence=clientSentence.toUpperCase()+'\n';
			outToClient.writeBytes(capitalizedSentence + '\n');
		}
	}
}
