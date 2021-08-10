package com.example.salesenquiry.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @Insert
    void SignUpDetails(CustomerDetails customerDetails);

    @Query("SELECT * FROM CustomerDetails Where email=:user_email and password=:user_password")
    CustomerDetails UserDetails(String user_email,String user_password);

}
