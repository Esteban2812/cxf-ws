package com.example.demo.ws;

import java.util.Map;

import com.example.demo.entity.IntegerUserMapAdapter;
import com.example.demo.entity.User;

import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface HelloWorld {
	String sayHi(String text);
	
	String sayHiToUser(User user);
	
	@XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
	Map<Integer, User> getUsers();
}
