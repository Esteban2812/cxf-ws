package com.example.demo.client;

import java.util.Map;

import javax.wsdl.extensions.soap12.SOAP12Binding;
import javax.xml.namespace.QName;

import com.example.demo.entity.User;
import com.example.demo.entity.UserImpl;
import com.example.demo.ws.HelloWorld;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.soap.SOAPBinding;

public class Client {

		private static final QName SERVICE_NAME
			= new QName("http://ws.demo.example.com/","HelloWorld");
		private static final QName PORT_NAME
		= new QName("http://ws.demo.example.com/","HelloWorldPort");
		
		private Client() {}
		
		public static void main(String[] args) throws Exception{
			Service service  = Service.create(SERVICE_NAME);
			
			String endpointAddress = "http://localhost:9000/helloWorld";
			
			service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
			
			HelloWorld hw = service.getPort(HelloWorld.class);
			System.out.println(hw.sayHi("World"));
			
			User user = new UserImpl("World*");
			System.out.println(hw.sayHiToUser(user));
			
			user = new UserImpl("Universe");
			System.out.println(hw.sayHiToUser(user));
			
			user = new UserImpl("Galaxy");
			System.out.println(hw.sayHiToUser(user));
			
			System.out.println();
			System.out.println("Users: ");
			Map<Integer, User> users = hw.getUsers();
			
			for(Map.Entry<Integer, User> e : users.entrySet()) {
				System.out.println(" " + e.getKey() + ": " + e.getValue().getName());
			}
		}
}
