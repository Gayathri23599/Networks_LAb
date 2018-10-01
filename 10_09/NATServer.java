import java.net.*;
import java.io.*;
public class NATServer{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(1234);
		Socket socket = server.accept();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String[] privateIPs = {"14.10.1.12","74.0.1.9"};
		String[] publicIPs = {"198.0.0.22","196.225.255.1"};
		PrintWriter p = new PrintWriter(socket.getOutputStream());
		String sendData = "", receiveData;
		while(true){
			int flag = 0;
			if((receiveData = receiveRead.readLine()) != null)
				System.out.println("Searching Public IP");
			for(int i = 0;i < privateIPs.length;i++){
				if(receiveData.equals(privateIPs[i])){
					flag = 1;
					sendData = publicIPs[i];
					break;
				}
			}
			if(flag == 1){
				p.println(sendData);
				p.flush();
			}
			else{
				p.println("Not registered");
				p.flush();
			}
		}
	}
}
