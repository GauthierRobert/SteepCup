package com.worldcup.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.worldcup.model.Game;
import com.worldcup.model.Player;
import com.worldcup.service.GameService;

public class MyTest {
	
	@Autowired
	private GameService gameService;
	
    @Test
    public void NewPlayer() {
        Player tester = new Player(); // MyClass is tested
        tester.setUsername("Gauthier");
//        System.out.println(tester);
//        System.out.println(tester.getNbrGoodDiff());
//        System.out.println(tester.getPoints());

    }
    
    @Test 
    public void InsertCountry() throws IOException { 
    	BufferedReader br = new BufferedReader(
    			new FileReader("C:\\JavaDevelopment\\MyWorkspaceEE\\SteepConsultCup\\src\\test\\java\\com\\worldcup\\test\\country.txt"));
	
		try {
	    	String line;
	    	while ((line = br.readLine()) != null) {
	    	
	    		//System.out.println("INSERT INTO worldcup.Countries (COUNTRY) value (\""+ line +"\");");

	    	
	    	}
		} finally {
			br.close();
		}
    }
    
    @Test 
    public void TestGroups()  { 
		String[] groups = {"A","B","C","D","E","F","G","H"};
		
		
		
		for (int i = 0; i < groups.length; i++) {
			System.out.println("group" + groups[i]);
		}
		
    }
		
    
}
