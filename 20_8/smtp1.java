import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
public class smtp1{
	public static void main(String[] args)throws Exception{
		String recipient = "iamanifs@gmail.com";
		String sender = "iamanifs@gmail.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host","smtp.gmail.com");
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
		message.setSubject("Subject");
		message.setText("Body of the mail");
		Transport.send(message);
		System.out.println("Mail successfully sent");
	}
}
