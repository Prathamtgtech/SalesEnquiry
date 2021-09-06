package com.example.salesenquiry.EnquiryFrom;

import androidx.room.PrimaryKey;

public class DataModel {
    @PrimaryKey(autoGenerate = true)
    int id;
    //Personal Details
    String FNAME;
    String LNAME;
    String LOCALITY;
    String CITY;
    int PINCODE;
    String TIME_TO_CALL;
    String PHONE;
    String ALTPHONE;
    String EMAIL;
    //Personal Details
    String GENDER;
    String STATUS;
    String OCCUPATION;
    String COMPANY_NAME;
    String DESIGNATION;
    String WORK_NATURE;
    String BUSINESS_LOCATION;
    //Need And Requirements
    String CONFIGURATION;
    String SPECIFY;
    String BUDGET;
    String LOAN;
    String BANKNAME;
    String PURCHASE;
    String RESIDENTAL;
    //About Project
    String NEWSPAPER_ADV;
    String NEWSPAPER_INSERT;
    String HORDING;
    String ADVERTISEMENT;
    String TELECALLING;
    String SOURCE;
    String BROKER;
    String REFER;


    //Constructor

    public DataModel() {
        this.id = id;
        this.FNAME = FNAME;
        this.LNAME = LNAME;
        this.LOCALITY = LOCALITY;
        this.CITY = CITY;
        this.PINCODE = PINCODE;
        this.TIME_TO_CALL = TIME_TO_CALL;
        this.PHONE = PHONE;
        this.ALTPHONE = ALTPHONE;
        this.EMAIL = EMAIL;
        this.GENDER = GENDER;
        this.STATUS = STATUS;
        this.OCCUPATION = OCCUPATION;
        this.COMPANY_NAME = COMPANY_NAME;
        this.DESIGNATION = DESIGNATION;
        this.WORK_NATURE = WORK_NATURE;
        this.BUSINESS_LOCATION = BUSINESS_LOCATION;
        this.CONFIGURATION = CONFIGURATION;
        this.SPECIFY = SPECIFY;
        this.BUDGET = BUDGET;
        this.LOAN = LOAN;
        this.BANKNAME = BANKNAME;
        this.PURCHASE = PURCHASE;
        this.RESIDENTAL = RESIDENTAL;
        this.NEWSPAPER_ADV = NEWSPAPER_ADV;
        this.NEWSPAPER_INSERT = NEWSPAPER_INSERT;
        this.HORDING = HORDING;
        this.ADVERTISEMENT = ADVERTISEMENT;
        this.TELECALLING = TELECALLING;
        this.SOURCE = SOURCE;
        this.BROKER = BROKER;
        this.REFER = REFER;
    }
    //getter settter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getLOCALITY() {
        return LOCALITY;
    }

    public void setLOCALITY(String LOCALITY) {
        this.LOCALITY = LOCALITY;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public int getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(int PINCODE) {
        this.PINCODE = PINCODE;
    }

    public String getTIME_TO_CALL() {
        return TIME_TO_CALL;
    }

    public void setTIME_TO_CALL(String TIME_TO_CALL) {
        this.TIME_TO_CALL = TIME_TO_CALL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getALTPHONE() {
        return ALTPHONE;
    }

    public void setALTPHONE(String ALTPHONE) {
        this.ALTPHONE = ALTPHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getOCCUPATION() {
        return OCCUPATION;
    }

    public void setOCCUPATION(String OCCUPATION) {
        this.OCCUPATION = OCCUPATION;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public void setCOMPANY_NAME(String COMPANY_NAME) {
        this.COMPANY_NAME = COMPANY_NAME;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public String getWORK_NATURE() {
        return WORK_NATURE;
    }

    public void setWORK_NATURE(String WORK_NATURE) {
        this.WORK_NATURE = WORK_NATURE;
    }

    public String getBUSINESS_LOCATION() {
        return BUSINESS_LOCATION;
    }

    public void setBUSINESS_LOCATION(String BUSINESS_LOCATION) {
        this.BUSINESS_LOCATION = BUSINESS_LOCATION;
    }

    public String getCONFIGURATION() {
        return CONFIGURATION;
    }

    public void setCONFIGURATION(String CONFIGURATION) {
        this.CONFIGURATION = CONFIGURATION;
    }

    public String getSPECIFY() {
        return SPECIFY;
    }

    public void setSPECIFY(String SPECIFY) {
        this.SPECIFY = SPECIFY;
    }

    public String getBUDGET() {
        return BUDGET;
    }

    public void setBUDGET(String BUDGET) {
        this.BUDGET = BUDGET;
    }

    public String getLOAN() {
        return LOAN;
    }

    public void setLOAN(String LOAN) {
        this.LOAN = LOAN;
    }

    public String getBANKNAME() {
        return BANKNAME;
    }

    public void setBANKNAME(String BANKNAME) {
        this.BANKNAME = BANKNAME;
    }

    public String getPURCHASE() {
        return PURCHASE;
    }

    public void setPURCHASE(String PURCHASE) {
        this.PURCHASE = PURCHASE;
    }

    public String getRESIDENTAL() {
        return RESIDENTAL;
    }

    public void setRESIDENTAL(String RESIDENTAL) {
        this.RESIDENTAL = RESIDENTAL;
    }

    public String getNEWSPAPER_ADV() {
        return NEWSPAPER_ADV;
    }

    public void setNEWSPAPER_ADV(String NEWSPAPER_ADV) {
        this.NEWSPAPER_ADV = NEWSPAPER_ADV;
    }

    public String getNEWSPAPER_INSERT() {
        return NEWSPAPER_INSERT;
    }

    public void setNEWSPAPER_INSERT(String NEWSPAPER_INSERT) {
        this.NEWSPAPER_INSERT = NEWSPAPER_INSERT;
    }

    public String getHORDING() {
        return HORDING;
    }

    public void setHORDING(String HORDING) {
        this.HORDING = HORDING;
    }

    public String getADVERTISEMENT() {
        return ADVERTISEMENT;
    }

    public void setADVERTISEMENT(String ADVERTISEMENT) {
        this.ADVERTISEMENT = ADVERTISEMENT;
    }

    public String getTELECALLING() {
        return TELECALLING;
    }

    public void setTELECALLING(String TELECALLING) {
        this.TELECALLING = TELECALLING;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getBROKER() {
        return BROKER;
    }

    public void setBROKER(String BROKER) {
        this.BROKER = BROKER;
    }

    public String getREFER() {
        return REFER;
    }

    public void setREFER(String REFER) {
        this.REFER = REFER;
    }
}
