package com.example.mam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoginFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
    }

    @Override
    public void onBackPressed() {
        Intent intent2 = new Intent(LoginFragment.this, MainActivity.class);
        startActivity(intent2);
    }
}