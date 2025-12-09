package com.aitrich.bank;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String accountType;     
    private double balance;
    private Customer customer;
    private String status;          
    private String hashedPin;       
    private LocalDate createdDate;

   

    public BankAccount(String accountNumber, String accountType, double balance,
                       Customer customer, String pin) {

        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
        this.status = "ACTIVE";
        this.createdDate = LocalDate.now();

       
        this.hashedPin = hashPin(pin);
    }

    

    private String hashPin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing PIN", e);
        }
    }

    

    public boolean validatePin(String inputPin) {
        String hashedInput = hashPin(inputPin);
        return hashedInput.equals(this.hashedPin);
    }

   

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getHashedPin() {
        return hashedPin;
    }

    public void setNewPin(String newPin) {
        this.hashedPin = hashPin(newPin);
    }

   

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", customer=" + (customer != null ? customer.getName() : "null") +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

