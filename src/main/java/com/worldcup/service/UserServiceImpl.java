package com.worldcup.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.worldcup.model.Player;
import com.worldcup.model.User;
import com.worldcup.repository.RoleRepository;
import com.worldcup.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    @Transactional
    public User save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        if (user.getUsername().equals("user_admin")) {
        	user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_ADMIN"))));
        }	else {
            user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }
        
        
        
        
        Player player = playerService.createPlayer(user.getUsername());
        user.setPlayer(player);
        

        
        user = userRepository.save(user);
        
        if (!user.getUsername().equals("user_admin")) {
        	gameService.createEmptyGroups(player);
        	gameService.createEmptyKnockOutStage(player);
        }
        
        return user;

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public String sha256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    
    public String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
    

}
