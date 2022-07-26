package com.example.DataBase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class interviewer {
    private String email;
    private String Password;
    private String Hr_email;
    private FirebaseDatabase root =FirebaseDatabase.getInstance();
    private DatabaseReference Refrence =root.getReference("Newcommer");
    public interviewer(String email,String Hr_email,String Password)
    {
        this.email=email;
        this.Hr_email=Hr_email;
        this.Password=Password;
    }
    public interviewer(String email)
    {
        this.email=email;
        this.Hr_email="waited";
    }
    public void registeration()
    {
        Refrence.child(email).setValue(email,Hr_email);
    }
}
