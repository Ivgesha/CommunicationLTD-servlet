package com.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {

	// Recipient's email ID needs to be mentioned.
	String to = "";

	// Sender's email ID needs to be mentioned
	String from = "";

	// Assuming you are sending email from localhost
	String host = "";

	String messageText = "";

	public SendMail(String to, String from, String messageText, String host) {

		System.out.println("SendMail constructor");
		this.to = to;
		this.from = from;
		this.host = host;
		this.messageText = messageText;
	}

	public void sendMailToClient() {
		
		//TODO 
		// We need to check why im getting connection refused from localhost:8443
		System.out.println(this.host);
		System.out.println("Trying to send  mail");
		System.out.println("Im in sendMailToClient ");
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText(messageText);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}
