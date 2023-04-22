package com.example.demo.Bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ATA_TBL_USER_PROFILE")
public class ProfileBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
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
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEmailID() {
        return emailID;
    }
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column
    private String firstName ;
    @Column
    private String lastName;
    @Column
    private String dateOfBirth;
    @Column
    private String gender;
    @Column
    private String  street;
    @Column
    private String location;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String pincode;
    @Column
    private String mobileNo;
    @Column
    private String emailID;
    @Column
    private String password;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="cbean")
   private CredentialsBean credentialBean;
public CredentialsBean getCredentialBean() {
    return credentialBean;
}
public void setCredentialBean(CredentialsBean credentialBean) {
    this.credentialBean = credentialBean;
}
   

}
