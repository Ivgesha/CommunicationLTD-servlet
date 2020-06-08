package com.model;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class PasswordHandler {

	private static final Random RANDOM = new SecureRandom();
	  private static final int ITERATIONS = 10000;
	  private static final int KEY_LENGTH = 256;
	  private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	
	
	public boolean passwordComparison(String pass1,String pass2) {
		if(pass1.equals(pass2)) {
			
			System.out.println("password are same\n");
			return true;
			
		}else {
			System.out.println("passwords are different\n");
			return false;
			
		}
		
	}
	
	
	// generating salt value in bytes
	public static byte[] generateSalt() {
	    byte[] salt = new byte[16];
	    RANDOM.nextBytes(salt);
	    return salt;
		
	}
	
	// converting byres to hex
	public static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();
		
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}
	
	
	// hashing using hmac - sha1 and salt 
	// salt value + data value -> hash
	public static String HmacSHA1(String data, String key)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
		{
		
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);
			return toHexString(mac.doFinal(data.getBytes()));
		}

	

	
	
}
