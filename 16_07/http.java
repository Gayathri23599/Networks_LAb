import java.io.*;
import java.net.*;
import java.util.*;
public class http{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(1234);
		while(true){
			try(Socket socket = server.accept()){	
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK \r\n\n\n" + today;
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
				/*PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println("HTTP/1.2 200 OK");
				out.println("Content-Type:text/html");
				out.println("\r\n");
				out.println("<strong><center>HTTP Using TCP Sockets</strong>");
				out.println("<marquee>Netwoks Lab</marquee>");
				out.println("<a href=\"http://localhost:1234\" target=\"blank\">click on me</a>");
				out.flush();
				out.close();*/
			}
		}
	}
}
