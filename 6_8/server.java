import java.io.*;
import java.net.*;
class server{
	public static void main(String[] args) throws Exception{
		ServerSocket obj = new ServerSocket(1234);
		Socket obj1 = obj.accept();
		while(true){
			DataInputStream din = new DataInputStream(obj1.getInputStream());
			DataOutputStream dout = new DataOutputStream(obj1.getOutputStream());
			String s = din.readLine();
			String ip[] = {"165.165.80.80" , "165.165.79.1"};
			String mac[] = {"6A:08:AA:C2" , "8A:BC:E3:FA"};
			for(int i = 0;i<ip.length;i++){
				if(s.equals(ip[i]))
					dout.writeBytes(mac[i] + '\n');
			}
			break;
		}
		//obj1.close();
	}
}
