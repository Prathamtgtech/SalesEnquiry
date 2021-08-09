package com.example.salesenquiry.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @Insert
    void SignUpDetails(CustomerDetails customerDetails);
    @Query("select * from CustomerDetails where name=:userId and password=:UserPassword")
    CustomerDetails UserDetails(String userId,String UserPassword);

}
