package com.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.PasswordHandler;
import com.dao.LoginDAOImpl;
import com.dao.LoginDao;
import com.entity.Login;

public class OperatorRegisterController extends HttpServlet {
	private Login user = null;
	private String hashedPass;
	private byte[] generatedSalt;
	private String saltString;
	private String dataPassword;
	String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
	char currentCharacter;
	boolean numberPresent = false;
	boolean upperCasePresent = false;
	boolean lowerCasePresent = false;
	boolean specialCharacterPresent = false;

	private static final long serialVersionUID = 1L;
	LoginDao loginDao = null;
	PasswordHandler passwordHandler = null;

	public OperatorRegisterController() {

		loginDao = new LoginDAOImpl();
		passwordHandler = new PasswordHandler();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		int i = 0;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String validationPassword = req.getParameter("validationPassword");

		System.out.println(validationPassword);

		if (passwordHandler.passwordComparison(password, validationPassword)) {
			// the password and the validationPassword are the same
			if (password.length() >= 10) {
				for (i = 0; i < password.length(); i++) {
					currentCharacter = password.charAt(i);
					if (Character.isDigit(currentCharacter)) {
						numberPresent = true;
					} else if (Character.isUpperCase(currentCharacter)) {
						upperCasePresent = true;
					} else if (Character.isLowerCase(currentCharacter)) {
						lowerCasePresent = true;
					} else if (specialChars.contains(String.valueOf(currentCharacter))) {
						specialCharacterPresent = true;
					}
				}

				if (numberPresent == true && upperCasePresent == true && lowerCasePresent == true
						&& specialCharacterPresent == true) {
					try {
						generatedSalt = PasswordHandler.generateSalt();
						saltString = PasswordHandler.toHexString(generatedSalt);
						dataPassword = saltString + password;
						// hashing the password and using the username as a key.
						hashedPass = PasswordHandler.HmacSHA1(dataPassword, username);
						user = new Login();
						user.setUsername(username);
						user.setPassword(hashedPass);
						user.setSalt(saltString);
						user.setEmail(email);
						loginDao.insertUser(user);
						// returning the vars to false for the next time
						numberPresent = false;
						upperCasePresent = false;
						lowerCasePresent = false;
						specialCharacterPresent = false;
					} catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {// password missing on of the specialChar,upperChar,lowerChar,digitChar
					System.out.println(
							"password missing one of the folowing: specialChar,upperChar,lowerChar, digitChar\n");
					// need to add redirects
					//resp.sendRedirect("/OperatorRegisterController");

				}

			} else {
				// password to short
				System.out.println("password to short");
				// need to add redirects
				//resp.sendRedirect("/OperatorRegisterController");

			}

		} else {

			// the password and the validationPassword dont match
			System.out.println("password and validationPassword dosent match");
			// need to add redirects
			//resp.sendRedirect("/OperatorRegisterController");
		}
		// need to create salt,
		// need to combind salt + password
		// then need to use func toHexString to generate hmac.
		// the save it to database.

		// TODO hash + salt the password , save the operator in the tbl_operators

		// loginDao.insertUser(login);

		// TODO after hashing the password , you will need to decrypt when
		// validating users

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("EDIT"))
			handleFrogetOperatorPassword(request, response);

	}

	public void handleFrogetOperatorPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("username");

		System.out.println("username -> " + username);

		// TODO set the operator password to null , send a new hashed value

		// TODO add a new page to enter the value send by mail , and redirecting
		// to change password page if values are matched
	}

}
