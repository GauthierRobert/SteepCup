package com.worldcup.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class Hash extends TestCase {
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Test
	public void testHash() throws NoSuchAlgorithmException {
		String password = "secret";
		String hash256 = sha256(password);
		//System.out.println(hash256);
	}
	
	
    public String sha256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    public  String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
    
    @Test
    public void shit() throws ParseException {
		Date now = new Date();
		Date submitDate = sdf.parse("2018/04/31 15:59:59");
		long diffInMillies = submitDate.getTime() - now.getTime();
		System.out.println(diffInMillies);
		
		
    }
    
    
    

}
