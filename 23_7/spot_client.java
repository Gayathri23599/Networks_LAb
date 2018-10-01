import java.io.*;
import java.net.*;
import java.util.*;
class spot_client{
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost",1234);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		out.writeBytes(s + '\n');
		//File file = new File("/home/pm/3521/23_7/doc.html");
		BufferedReader br = new BufferedReader(new FileReader("doc.html"));
		String st = br.readLine();
		while(st != null){
			System.out.println(st);
			st = br.readLine();
		}
		client.close();
	}
}
		
