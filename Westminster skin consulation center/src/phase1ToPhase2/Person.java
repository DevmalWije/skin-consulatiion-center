package phase1ToPhase2;

import java.util.Date;
//Creating person super class
public class Person {
    //Defining person class arguments
    private String name;
    private String surName;
    private String mobileNumber;
    private Date dateOfBirth;
    private String NIC;
    
    //Creating person class constructor
    public Person(String name, String surName, String mobileNumber, Date dateOfBirth, String NIC) {
        this.name = name;
        this.surName = surName;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.NIC = NIC;
    }

    //Creating getters and setters for person class arguments
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

}