package com.example.demo.ws;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.entity.User;

import jakarta.jws.WebService;

@WebService(endpointInterface="com.example.demo.ws.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	Map<Integer, User> users = new LinkedHashMap<Integer, User>();
	
	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}
	
	public String sayHiToUser(User user) {
		System.out.println("sayHiToUser called");
		users.put(users.size() + 1, user);
		return "Hello " + user.getName();
	}
	
	public Map<Integer, User> getUsers(){
		System.out.println("getUsers Called");
		return users;
	}
}
