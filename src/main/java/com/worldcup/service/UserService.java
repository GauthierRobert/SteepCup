package com.worldcup.service;

import java.security.NoSuchAlgorithmException;

import com.worldcup.model.User;

public interface UserService {
	
	String sha256(String data) throws NoSuchAlgorithmException;
	
	String bytesToHex(byte[] bytes);

	User findByUsername(String username);

	User save(User user);

}
