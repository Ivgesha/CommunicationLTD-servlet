package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// entering the page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("heyoo entered doGet ");

	}

	// pressing submit
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("heyoo entered doPost ");

		// Recipient's email ID needs to be mentioned.
		String to = "evgenise093@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "web@gmail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		// maybe need to be Session session =
		// Session.getDefaultInstance(properties,null);
		Session session = Session.getDefaultInstance(properties);

		//try {
			// Create a default MimeMessage object.
			//MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			//message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			//message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			//message.setSubject("This is the Subject Line!");

			// Now set the actual message
			//message.setText("This is actual message");

			// Send message
			//Transport.send(message);
			System.out.println("Sent message successfully....");
		//} 
		//catch (MessagingException mex) {
			//mex.printStackTrace();
		//}

	}

}
