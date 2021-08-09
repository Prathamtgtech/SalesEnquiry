package com.example.salesenquiry.Database;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {CustomerDetails.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DAO Dao();
}
