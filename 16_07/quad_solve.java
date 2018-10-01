import java.io.*;
import java.net.*;
import java.lang.*;
public class quad_solve{
	/*public static int number(String a){
		switch(a){
		case "0" : return 0;
		case "1" : return 1;
		case
		default : return 3;
		}
	}*/
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(5080);
		int d;
		while(true){
			Socket socket = serverSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream outFromServer = new DataOutputStream(socket.getOutputStream());
			String sentence = new String("Enter a:");
			outFromServer.writeBytes(sentence + '\n');
			sentence = inFromClient.readLine();
			int a = Integer.parseInt(sentence);
			sentence = inFromClient.readLine();
			int b = Integer.parseInt(sentence);
			sentence = inFromClient.readLine();
			int c = Integer.parseInt(sentence);
			int inter = (int)Math.sqrt((b * b) - (4 * a * c));
			if(inter < 0 ){ 
				sentence = new String("No real roots");
			}
			else{
				if(inter == 0){
					d = -b / (2 * a);
					sentence = Integer.toString(d);
				}
				else{
					d = (-b + inter) / (2 * a);
					sentence = Integer.toString(d);
					d = (-b - inter) / (2 * a);
					sentence += " , " + Integer.toString(d); 
				}
			}
			outFromServer.writeBytes(sentence + '\n');
			//System.out.println(sentence);
		}
	}
}
