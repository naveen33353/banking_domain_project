package com.aitrich.bank;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	private String customerId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private List<BankAccount>accounts=new ArrayList<>();
	
	
	public Customer(String customerId, String name, String email, String phoneNumber, String address, List<BankAccount>accounts) {
		this.customerId=customerId;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.accounts=(accounts !=null)? accounts: new ArrayList<>();
	}
	
	public void setCustomerId(String cId) {
		customerId=cId;
	}
	public String getCustomerId() {
		return customerId;
	}
	
	
	public void setName(String cName) {
		name=cName;
	}
	public String getName() {
		return name;
	}
	
	public void setEmail(String mail) {
		email=mail;
	}
	public String getEmail() {
		return email;
	}
	
	
	public void setPhoneNumber(String phone) {
		phoneNumber=phone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setAddress(String addr) {
		address=addr;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAccounts(List<BankAccount>acc) {
		accounts=acc;
	}
	public List<BankAccount>getAccounts(){
		return accounts;
	}
	
	
	
	
	@Override
	public String toString() {
	    return "Customer{" +
	           "customerId='" + customerId + '\'' +
	           ", name='" + name + '\'' +
	           ", email='" + email + '\'' +
	           ", phoneNumber='" + phoneNumber + '\'' +
	           ", address='" + address + '\'' +
	           ", accounts=" + accounts +
	           '}';
	}


}
