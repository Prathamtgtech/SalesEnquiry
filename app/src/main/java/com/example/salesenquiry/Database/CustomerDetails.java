package com.example.salesenquiry.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomerDetails {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;
    String password;

    //constructor
    public CustomerDetails() {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //Getter And Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
