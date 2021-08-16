package com.example.salesenquiry.EnquiryFormDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FormDetails {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String locality;
    String city;
    int pincode;
    String timetocall;
    int phone;
    int altphone;
    String email;
    String education;
    String occupation;
    String companyname;
    String designation;
    String worknature;
    String businesslocation;
    String configuration;
    String budeget;
    String homeloan;
    String bankname;
    String purchase;
    String residantal;
    String advertisment;
    String newspaper;
    String hording;
    String seeadvertisment;
    int telecalling;
    String source;
    String refer;
    String partner;


    //construtor

    public FormDetails() {
        this.id=id;
        this.name = name;
        this.locality = locality;
        this.city = city;
        this.pincode = pincode;
        this.timetocall = timetocall;
        this.phone = phone;
        this.altphone = altphone;
        this.email = email;
        this.education = education;
        this.occupation = occupation;
        this.companyname = companyname;
        this.designation = designation;
        this.worknature = worknature;
        this.businesslocation = businesslocation;
        this.configuration = configuration;
        this.budeget = budeget;
        this.homeloan = homeloan;
        this.bankname = bankname;
        this.purchase = purchase;
        this.residantal = residantal;
        this.advertisment = advertisment;
        this.newspaper = newspaper;
        this.hording = hording;
        this.seeadvertisment = seeadvertisment;
        this.telecalling = telecalling;
        this.source = source;
        this.refer = refer;
        this.partner = partner;
    }

    //Getter And Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getTimetocall() {
        return timetocall;
    }

    public void setTimetocall(String timetocall) {
        this.timetocall = timetocall;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAltphone() {
        return altphone;
    }

    public void setAltphone(int altphone) {
        this.altphone = altphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWorknature() {
        return worknature;
    }

    public void setWorknature(String worknature) {
        this.worknature = worknature;
    }

    public String getBusinesslocation() {
        return businesslocation;
    }

    public void setBusinesslocation(String businesslocation) {
        this.businesslocation = businesslocation;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getBudeget() {
        return budeget;
    }

    public void setBudeget(String budeget) {
        this.budeget = budeget;
    }

    public String getHomeloan() {
        return homeloan;
    }

    public void setHomeloan(String homeloan) {
        this.homeloan = homeloan;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public String getResidantal() {
        return residantal;
    }

    public void setResidantal(String residantal) {
        this.residantal = residantal;
    }

    public String getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(String advertisment) {
        this.advertisment = advertisment;
    }

    public String getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(String newspaper) {
        this.newspaper = newspaper;
    }

    public String getHording() {
        return hording;
    }

    public void setHording(String hording) {
        this.hording = hording;
    }

    public String getSeeadvertisment() {
        return seeadvertisment;
    }

    public void setSeeadvertisment(String seeadvertisment) {
        this.seeadvertisment = seeadvertisment;
    }

    public int getTelecalling() {
        return telecalling;
    }

    public void setTelecalling(int telecalling) {
        this.telecalling = telecalling;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
