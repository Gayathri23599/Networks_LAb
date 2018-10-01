import java.io.*;
import java.lang.Runtime;
public class IP{
	public static void main(String[] args) throws Exception{
		Process publicIP = Runtime.getRuntime().exec("curl ifconfig.me");
		Process privateIP = Runtime.getRuntime().exec("hostname -I");
		BufferedReader publicIPReader = new BufferedReader(new InputStreamReader(publicIP.getInputStream()));
		BufferedReader privateIPReader = new BufferedReader(new InputStreamReader(privateIP.getInputStream()));
		String publicIPString, privateIPString;
		System.out.println("My Private IP:");
		while((privateIPString = privateIPReader.readLine()) != null)
			System.out.println(privateIPString);
		System.out.println("My Public IP:");
		while((publicIPString = publicIPReader.readLine()) != null)
			System.out.println(publicIPString);
	}
}
