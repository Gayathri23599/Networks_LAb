import java.io.*;
import java.util.*;
import java.lang.*;
class Bucket{
	public int token, maxsize;
	Bucket(int a){
		token = 0;
		maxsize = a;
	}
	synchronized void addToken(int n){
		if(token >= maxsize)
			return;
		token += 1;
		System.out.println("Added a token. Total : " + token);
	}
	synchronized void sendPacket(int n){
		System.out.println("Packet of size " + n + " arrived");
		if(n > token)
			System.out.println("Packet is discovered");
		else{
			token = n;
			System.out.println("Forwarding packet");
		}
	}
}
class AddTokenThread extends Thread{
	Bucket b;
	AddTokenThread(Bucket b){
		this.b = b;
	}
	public void run(){
		while(true){
			b.addToken(1);
			try{
				Thread.sleep(300);
			}
			catch(Exception e){}
		}
	}
}
class AddPacketThread extends Thread{
	Bucket b;
	AddPacketThread(Bucket b){
		this.b = b;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(500 + (int)(Math.random()*3000));
			} 
			catch(Exception e){}
			b.sendPacket(1 + (int)(Math.random()*9));
		}
	}
}
public class tcp{
	public static void main(String[] args){
		Bucket b = new Bucket(10);
		Thread tokens = new AddTokenThread(b);
		Thread packets = new AddPacketThread(b);
		try{
			tokens.start();
			packets.start();
		}
		catch(Exception e){}
	}
}
