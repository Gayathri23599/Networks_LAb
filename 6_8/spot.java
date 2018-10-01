import java.io.*;
import java.net.*;
public class spot{
	public static void main(String[] args) throws Exception{
		String str = null;
		Process p = Runtime.getRuntime().exec("arp -a");
		BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((str = buf.readLine()) != null){
			System.out.println(str);
		}
	}
}

