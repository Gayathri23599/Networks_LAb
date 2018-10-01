import java.io.*;
import java.net.*;
import java.util.*;
class spot_server{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(1234);
		while(true){
			Socket socket = server.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String url = inFromClient.readLine();
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Socket website = new Socket(InetAddress.getByName(url),80);
			PrintWriter pw = new PrintWriter(website.getOutputStream());
			//BufferedReader br = new BufferedReader(new InputStreamReader(website.getInputStream()));
			pw.println("GET / HTTP/1.1");
			pw.println("Host: " + url);
			pw.println("");
			pw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(website.getInputStream()));
			//String[] fileName = url.split(".",3); 	
			//System.out.println(fileName[1]);
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("doc.html"),"UTF-8"));
			String t = br.readLine();
			while(t != null){
				writer.write(t + '\n');
				t = br.readLine();
			}
			File file = new File("doc.html");
			System.out.println("File size: " + file.length());
			writer.close();
			break;
		}
	}
}			
			
