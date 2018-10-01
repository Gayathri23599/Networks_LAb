import java.io.*;
import java.net.*;
class pingServer{
	public static void main(String[] args) throws Exception{
		String str;
		BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
		String ip = buf1.readLine();
		Runtime H = Runtime.getRuntime();
		Process p = H.exec("ping " + ip);
		BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((str = buf2.readLine()) != null)
			System.out.println("  " + str);
	}
} 
