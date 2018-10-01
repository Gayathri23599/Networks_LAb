import java.io.*;
import java.net.*;
class client{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Socket cl = new Socket("127.0.0.1",1234);
		DataInputStream din = new DataInputStream(cl.getInputStream());
		DataOutputStream dout = new DataOutputStream(cl.getOutputStream());
		System.out.println("Enter logical address");
		String s1 = in.readLine();
		dout.writeBytes(s1 + '\n');
		String s = din.readLine();
		System.out.println("Physical address : " + s);
		cl.close();
	}
}	
