package com.example.salesenquiry.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class FormDB extends SQLiteOpenHelper {
    public static final String DB_NAME="Customer.db";

    public FormDB(@Nullable Context context) {
        super(context,DB_NAME,null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create table CustData(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FNAME TEXT,LNAME,LOCALITY TEXT,CITY TEXT,PINCODE INTEGER,TIME_TO_CALL TEXT,PHONE TEXT,ALTPHONE TEXT,EMAIL TEXT,"+
                "GENDER TEXT,STATUS TEXT,OCCUPATION TEXT,COMPANY_NAME TEXT,DESIGNATION TEXT,WORK_NATURE TEXT,BUSINESS_LOCATION TEXT,"+
                "CONFIGURATION TEXT,SPECIFY TEXT,BUDGET TEXT,LOAN TEXT,BANK_NAME TEXT,PURCHASE TEXT,RESIDENTAL TEXT," +
                "NEWSPAPER_ADV TEXT,NEWSPAPER_INSERT TEXT,HORDING TEXT,DIGITAL TEXT,TELECALLING TEXT,SOURCE TEXT,BROKER TEXT,REFER TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP Table if exists CustData");
    }

    public Boolean InsertFormData(String Fname,String Lname, String Locality, String City, int Pincode, String Time_to_call, String Phone, String Altphone, String Email,
                                  String Gender,String Status, String Occupation, String Company_name, String Designation, String Work_nature, String Business_location,
                                  String Configuration, String Specify, String Budget, String Loan, String Bankname, String Purchase, String Residental,
                                  String Newspaper_adv , String Newspaper_insert, String Hording, String Digital, String Telecalling, String Source, String Broker, String Refer){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //persona details
        values.put("FNAME",Fname);
        values.put("LNAME",Lname);
        values.put("LOCALITY",Locality);
        values.put("CITY",City);
        values.put("PINCODE",Pincode);
        values.put("TIME_TO_CALL",Time_to_call);
        values.put("PHONE",Phone);
        values.put("ALTPHONE",Altphone);
        values.put("EMAIL",Email);
        //Personal Details 2
        values.put("GENDER",Gender);
        values.put("STATUS",Status);
        values.put("OCCUPATION",Occupation);
        values.put("COMPANY_NAME",Company_name);
        values.put("DESIGNATION",Designation);
        values.put("WORK_NATURE",Work_nature);
        values.put("BUSINESS_LOCATION",Business_location);
        //Need and Requirement
        values.put("CONFIGURATION",Configuration);
        values.put("SPECIFY",Specify);
        values.put("BUDGET",Budget);
        values.put("LOAN",Loan);
        values.put("BANK_NAME",Bankname);
        values.put("PURCHASE",Purchase);
        values.put("RESIDENTAL",Residental);
        //About project
        values.put("NEWSPAPER_ADV",Newspaper_adv);
        values.put("NEWSPAPER_INSERT",Newspaper_insert);
        values.put("HORDING",Hording);
        values.put("DIGITAL",Digital);
        values.put("TELECALLING",Telecalling);
        values.put("SOURCE",Source);
        values.put("BROKER",Broker);
        values.put("REFER",Refer);
        long result=db.insert("CustData",null,values);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor FetchCustData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="Select * from CustData";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }

    public Boolean UpdateFormData(String FNAME,String LNAME, String LOCALITY, String CITY, int PINCODE, String TIME_TO_CALL, String PHONE, String ALTPHONE, String EMAIL,
                                  String GENDER,String STATUS, String OCCUPATION, String COMPANY_NAME, String DESIGNATION, String WORK_NATURE, String BUSINESS_LOCATION,
                                  String CONFIGURATION, String SPECIFY, String BUDGET, String LOAN, String BANKNAME, String PURCHASE, String RESIDENTAL,
                                  String NEWSPAPER_ADV , String NEWSPAPER_INSERT, String HORDING, String ADVERTISEMENT, String TELECALLING, String SOURCE, String BROKER, String REFER){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //persona details
        values.put("FNAME",FNAME);
        values.put("LNAME",LNAME);
        values.put("LOCALITY",LOCALITY);
        values.put("CITY",CITY);
        values.put("PINCODE",PINCODE);
        values.put("TIME_TO_CALL",TIME_TO_CALL);
        values.put("PHONE",PHONE);
        values.put("ALTPHONE",ALTPHONE);
        values.put("EMAIL",EMAIL);
        //Personal Details 2
        values.put("GENDER",GENDER);
        values.put("STATUS",STATUS);
        values.put("OCCUPATION",OCCUPATION);
        values.put("COMPANY_NAME",COMPANY_NAME);
        values.put("DESIGNATION",DESIGNATION);
        values.put("WORK_NATURE",WORK_NATURE);
        values.put("BUSINESS_LOCATION",BUSINESS_LOCATION);
        //Need and Requirement
        values.put("CONFIGURATION",CONFIGURATION);
        values.put("SPECIFY",SPECIFY);
        values.put("BUDGET",BUDGET);
        values.put("LOAN",LOAN);
        values.put("BANK_NAME",BANKNAME);
        values.put("PURCHASE",PURCHASE);
        values.put("RESIDENTAL",RESIDENTAL);
        //About project
        values.put("NEWSPAPER_ADV",NEWSPAPER_ADV);
        values.put("NEWSPAPER_INSERT",NEWSPAPER_INSERT);
        values.put("HORDING",HORDING);
        values.put("ADVERTISEMENT",ADVERTISEMENT);
        values.put("TELECALLING",TELECALLING);
        values.put("SOURCE",SOURCE);
        values.put("BROKER",BROKER);
        values.put("REFER",REFER);
        long result=db.update("CustData",values,"id=?",null);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
