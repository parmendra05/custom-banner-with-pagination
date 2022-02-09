package com.pack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
@Id
Integer aadharNum;
String name;
String city;
String state;

public Person() {
	// TODO Auto-generated constructor stub
}

public Person(Integer aadharNum, String name,  String city, String state) {
	super();
	this.aadharNum = aadharNum;
	this.name = name;
	this.city = city;
	this.state = state;
}

public Integer getAadharNum() {
	return aadharNum;
}

public void setAadharNum(Integer aadharNum) {
	this.aadharNum = aadharNum;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

@Override
public String toString() {
	return "Person [aadharNum=" + aadharNum + ", name=" + name + ", city=" + city + ", state=" + state + "]";
}



}
