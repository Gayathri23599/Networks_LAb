import java.io.*;
import java.net.*;
public class NATClient{
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",1234);
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(socket.getOutputStream());
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String receiveData, sendData;
		while(true){
			System.out.println("Enter your private IP:");
			sendData = keyRead.readLine();
			p.println(sendData);
			p.flush();
			System.out.println("Your Public IP:");
			if((receiveData = receiveRead.readLine()) != null)
				System.out.println(receiveData);
			if(receiveData.equals("Not registered"))
				System.out.println("You're not a registered user");
			else
				System.out.println("You're a registered user");
		}
	}
}
