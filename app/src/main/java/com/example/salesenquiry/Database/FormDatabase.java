package com.example.salesenquiry.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FormDatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "Form.DB";

    public FormDatabase(Context context) {
        super(context,DBNAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create TABLE ENQUIRY(_id INTEGER PRIMARY KEY AUTOINCREMENT,/*Personal*/ Name TEXT,Localitys TEXT,City TEXT,Pincode INTEGER,Timetocall TEXT,Phones TEXT,Altphone TEXT,Email TEXT/*Personal 2*/, Education TEXT,Occupation TEXT,Company_name TEXT,Designation TEXT,Worknature TEXT,Business_location TEXT,/*Need And Require*/ Configuration TEXT,Specify TEXT,Budget TEXT,Loan TEXT,Bank_name TEXT,Purchase TEXT,Residantal TEXT,/*About Project */ News_paper TEXT,Insert_newspaper TEXT,Advertisement TEXT,Telecalling TEXT,Source TEXT,Refer TEXT,Partner TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP Table if exists users");
    }

    public Boolean InsertValues(String Names, String Localitys, String Citys, int Pincodes, String Timetocalls, String Phones, String Altphones, String Emails, String Educations, String Occupations, String Company_names, String Designations, String Work_natures, String Business_locations, String Configurations, String Specifys, String Budgets, String Loans, String Banknames, String Purchases, String Residantals, String Newspapers, String Insert_newspapers, String Hordings, String Advertisements, String Telecallings, String Sources, String Refers, String Partners){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //Personal
        contentValues.put("Name",Names);
        contentValues.put("Locality",Localitys);
        contentValues.put("City",Citys);
        contentValues.put("Pincodes", Pincodes);
        contentValues.put("Timers",Timetocalls);
        contentValues.put("Phones",Phones );
        contentValues.put("AltPhones", Altphones);
        contentValues.put("Emails",Emails);
        //Personal 2
        contentValues.put("Education", Educations);
        contentValues.put("Occupation", Occupations);
        contentValues.put("CompanyName", Company_names);
        contentValues.put("Designation", Designations);
        contentValues.put("WorkNature", Work_natures);
        contentValues.put("BusinessLocation", Business_locations);
        //Need & Requirment
        contentValues.put("Configurtaion", Configurations);
        contentValues.put("SPECIFY", Specifys);
        contentValues.put("BUDGET", Budgets);
        contentValues.put("Loan", Loans);
        contentValues.put("BankName",Banknames);
        contentValues.put("Purchase", Purchases);
        contentValues.put("Residantal", Residantals);
        //About Project
        contentValues.put("NEWSPAPER",Newspapers);
        contentValues.put("PAPERNAME",Insert_newspapers);
        contentValues.put("HORDING", Hordings);
        contentValues.put("ADVERTISMENT",Advertisements);
        contentValues.put("TELE", Telecallings);
        contentValues.put("SOURCE", Sources);
        contentValues.put("REFER",Refers);
        contentValues.put("PARTNER",Partners);
        long result=db.insert("ENQUIRY",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
