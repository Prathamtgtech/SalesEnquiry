package com.example.salesenquiry.EnquiryFormDatabase;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface enq_DAO {

    @Insert
    void InsertFormData(FormDetails formDetails);
}
