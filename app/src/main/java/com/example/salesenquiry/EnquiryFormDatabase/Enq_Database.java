package com.example.salesenquiry.EnquiryFormDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FormDetails.class},version = 1,exportSchema = false)
public abstract class Enq_Database extends RoomDatabase {
    public abstract enq_DAO getEnqDao();
}
