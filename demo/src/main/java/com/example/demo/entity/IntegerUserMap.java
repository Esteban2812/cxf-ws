package com.example.demo.entity;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
@XmlType(name = "IntegerUserMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerUserMap {
	@XmlElement(nillable = false, name = "entry")
	List<IntegerUserEntry> entries = new ArrayList<>();

	public List<IntegerUserEntry> getEntries(){
		return entries;
	}
	


	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "IdentifiedUser")
	static class IntegerUserEntry {
		@XmlElement(required = true, nillable = false)
		Integer id;
		
		User user;
	
		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		public User getUser() {
			return user;
		}
	
		public void setUser(User user) {
			this.user = user;
		}
		
		
	}
}	