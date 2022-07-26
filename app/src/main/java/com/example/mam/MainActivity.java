package com.example.mam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
MeowBottomNavigation bottomNavigation;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_about_us));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_login));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_registeration));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.ic_book));
        bottomNavigation.add(new MeowBottomNavigation.Model(6,R.drawable.ic_menu_book));
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //intinalize fragment
                Fragment fragment=null;
                //check condation
                int id=item.getId();
                boolean is_fragment=true;
                switch (item.getId()){
                    case 1:
                        //when id is 1
                        //intianalize about_us
                        fragment=new About_UsFragment();
                        break;
                    case 2:
                        //when id is 2
                        //intianalize Home
                        fragment=new HomeFragment();
                        break;
                    case 3:
                        //when id is 3
                        //intianalize Login
                       is_fragment=false;
                        break;
                    case 4:
                        //when id is 4
                        //intianalize Registeration
                       is_fragment=false;
                        break;
                    case 5:
                        //when id is 5
                        //intianalize our_list
                        fragment=new our_ListFragment();
                        break;
                    case 6:
                        //when id is 6
                        //intianalize achievment
                        is_fragment=false;
                        break;
                }
                //load fragment
                fragment(is_fragment,fragment,id);
            }
        });
        //set notification count
        bottomNavigation.setCount(1,"10");
        bottomNavigation.setCount(3,"10");
        bottomNavigation.setCount(4,"10");
        bottomNavigation.setCount(5,"10");
        bottomNavigation.setCount(6,"10");
        //set home fragment intially slected
        bottomNavigation.show(2,true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Display toast
                Toast.makeText(getApplicationContext(),"You Clicked"+item.getId(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //Display toast
                Toast.makeText(getApplicationContext(),"You ReClicked"+item.getId(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadFragment(Fragment fragment)
    {
        //Replace Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
    private void loadintent(int id)
    {
        switch (id){
            case 3:
                //when id is 1
                //intianalize about_us
                Intent intent = new Intent(MainActivity.this, LoginFragment.class);
                startActivity(intent);
                break;
            case 4:
                Intent intent2 = new Intent(MainActivity.this, RegisterationFragment.class);
                startActivity(intent2);
                break;
            case 6:
                Intent intent3 = new Intent(MainActivity.this, Achievement.class);
                startActivity(intent3);
                break;
        }
    }
    private void fragment(boolean fragment,Fragment t,int id)
    {
        if (fragment)
        {
            loadFragment(t);
        }
        else
        {
            loadintent(id);
        }
    }
    long time;
    int counter =0;
    public void onBackPressed() {
        counter++;
        if (counter==2) {
            finishAffinity();
            super.onBackPressed();
        }
        else
            {
            Toast.makeText(getApplicationContext(), "Press Back again", Toast.LENGTH_SHORT).show();
            }
    }

}