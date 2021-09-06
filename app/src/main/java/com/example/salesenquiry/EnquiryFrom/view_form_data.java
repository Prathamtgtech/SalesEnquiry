package com.example.salesenquiry.EnquiryFrom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.salesenquiry.Database.FormDB;
import com.example.salesenquiry.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class view_form_data extends AppCompatActivity {
    RecyclerView rcv;
    ArrayList<DataModel> dataView = new ArrayList<DataModel>();
    DataModel dataModel;
    Cursor cursor;
    MyDataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form_data);
        rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
       cursor = new FormDB(this).FetchCustData();
        FetchData();
    }


    private void FetchData() {
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            dataModel.setId(cursor.getInt(0));
            dataModel.setFNAME(cursor.getString(1));
            dataModel.setLNAME(cursor.getString(2));
            dataModel.setLOCALITY(cursor.getString(3));
            dataModel.setCITY(cursor.getString(4));
            dataModel.setPINCODE(cursor.getInt(5));
            dataModel.setTIME_TO_CALL(cursor.getString(6));
            dataModel.setPHONE(cursor.getString(7));
            dataModel.setALTPHONE(cursor.getString(8));
            dataModel.setEMAIL(cursor.getString(9));
            //Personal Details
            dataModel.setGENDER(cursor.getString(10));
            dataModel.setSTATUS(cursor.getString(11));
            dataModel.setOCCUPATION(cursor.getString(12));
            dataModel.setCOMPANY_NAME(cursor.getString(13));
            dataModel.setDESIGNATION(cursor.getString(14));
            dataModel.setWORK_NATURE(cursor.getString(15));
            dataModel.setBUSINESS_LOCATION(cursor.getString(16));
            //Need And Requirment
            dataModel.setCONFIGURATION(cursor.getString(17));
            dataModel.setSPECIFY(cursor.getString(18));
            dataModel.setBUDGET(cursor.getString(19));
            dataModel.setLOAN(cursor.getString(20));
            dataModel.setBANKNAME(cursor.getString(21));
            dataModel.setPURCHASE(cursor.getString(22));
            dataModel.setRESIDENTAL(cursor.getString(23));
            //About Project
            dataModel.setNEWSPAPER_ADV(cursor.getString(24));
            dataModel.setNEWSPAPER_INSERT(cursor.getString(25));
            dataModel.setHORDING(cursor.getString(26));
            dataModel.setADVERTISEMENT(cursor.getString(27));
            dataModel.setTELECALLING(cursor.getString(28));
            dataModel.setSOURCE(cursor.getString(29));
            dataModel.setBROKER(cursor.getString(30));
            dataModel.setREFER(cursor.getString(31));
            dataView.add(dataModel);
        }
        adapter = new MyDataAdapter(dataView, getApplicationContext());
        rcv.setAdapter(adapter);
    }

}