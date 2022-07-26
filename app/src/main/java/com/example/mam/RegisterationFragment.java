package com.example.mam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.DataBase.interviewer;
import com.example.DataBase.Person;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterationFragment extends AppCompatActivity {
    private EditText phone,level,email,adress,name,id;
    private FirebaseDatabase root =FirebaseDatabase.getInstance();
    private DatabaseReference Refrence =root.getReference(Person.class.getSimpleName());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registeration);
        phone=findViewById(R.id.Phone);
        level=findViewById(R.id.level);
        email=findViewById(R.id.Email);
        adress=findViewById(R.id.Adress);
        name=findViewById(R.id.Name);
        id=findViewById(R.id.ID);
    }
    public void onBackPressed() {
        Intent intent2 = new Intent(RegisterationFragment.this, MainActivity.class);
        startActivity(intent2);
    }
    public void Registeration(View t)
    {
        String Phone,Level,Email,Adress,Name;
        int Id;
        Phone=phone.getText().toString();
        Level=level.getText().toString();
        Email=email.getText().toString();
        Adress=adress.getText().toString();
        Name=name.getText().toString();
        Id=Integer.parseInt(id.getText().toString());
        Person Newcommer=new Person(Phone,Id,Email,Name,Level,Adress);
        registeration(Email,Newcommer);
        //interviewer Interviewer =new interviewer(Email);
        //Interviewer.registeration();
    }
    public void registeration(String email,Object o)
    {
         FirebaseDatabase root =FirebaseDatabase.getInstance();
         DatabaseReference Refrence =root.getReference("Person");
        Refrence.child(email).push().setValue(o);
    }

}