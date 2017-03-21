package dd_util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import dd_testCore.testCore;

public class SendAlertMailTest extends testCore {

	
	public static String TO = "raghavendra_uday@yahoo.com";
	public static String CC = "iloveraghu2008@gmail.com";
	

	public static void SendDetail(String from, String pass, String TO, String CC, String subject, String body) {

		Properties props = System.getProperties();
			
		//YAHOO
		String host ="smtp.mail.yahoo.com";
		//String host = "plus.smtp.mail.yahoo.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);	
		props.put("mail.debug", "false");
	
		//props.put("mail.smtp.port", "587");
		props.put("mail.smtp.port", "465");
		//props.put("mail.smtp.port", "25");
		
		props.put("mail.smtp.auth", "true");
		

		Session session = Session.getDefaultInstance(props);

		MimeMessage message = new MimeMessage(session);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm aa");
		final String formattedDate = dateFormat.format(new Date()).toString();

		try {

			// Set from address
			message.setFrom(new InternetAddress(from));

			InternetAddress[] iAdressArray = InternetAddress.parse(TO);
			message.addRecipients(Message.RecipientType.TO, iAdressArray);
			
			InternetAddress[] iAddressArray2 = InternetAddress.parse(CC);
			message.addRecipients(Message.RecipientType.CC, iAddressArray2);
			
			// Set subject
			message.setSubject(subject);

			//message.setText(body);
			message.setContent(body,"text/html");

			BodyPart objMessageBodyPart = new MimeBodyPart();

			//objMessageBodyPart.setText(body);
			objMessageBodyPart.setContent(body,"text/html");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String Path = src.toString();
					
			DataSource source = new FileDataSource(Path);
			objMessageBodyPart.setDataHandler(new DataHandler(source));
			objMessageBodyPart.setFileName(Path);
			multipart.addBodyPart(objMessageBodyPart);
			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		}

		catch (AddressException ae) {

			ae.printStackTrace();

		}

		catch (MessagingException me) {

			me.printStackTrace();

		}

	}
	
}
