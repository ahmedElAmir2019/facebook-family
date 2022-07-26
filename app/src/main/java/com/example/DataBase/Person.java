package com.example.DataBase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Person {
    private int id ;
    private String email ;
    private String phone ;
    private String Name ;
    private String level ;
    private String city ;
    private String street_name ;
    private String Home_number ;
    private String Adress ;
 //   private FirebaseDatabase root =FirebaseDatabase.getInstance();
  //  private DatabaseReference Refrence =root.getReference("Newcommer");
    public Person(String phone,int id ,String email,String Name,String level,String Adress) {
        this.phone = phone;
        this.id=id;
        this.Adress=Adress;
        this.email=email;
        this.Name=Name;
        this.level=level;
    }

}
