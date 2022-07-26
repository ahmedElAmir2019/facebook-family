package com.example.mam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Achievement extends AppCompatActivity {
private ViewPager slide_show;
private LinearLayout dots;
private slider_adapter sliderAdapter;
private TextView[] Dots;
private Button next_button;
private Button back_button;
private int current_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        slide_show=(ViewPager) findViewById(R.id.slideviewer);
        dots=(LinearLayout) findViewById(R.id.dots_layout);
        next_button=(Button) findViewById(R.id.next);
        back_button=(Button) findViewById(R.id.back);
        sliderAdapter=new slider_adapter(this);
        slide_show.setAdapter(sliderAdapter);
        addDotsIndictor(0);
        slide_show.addOnPageChangeListener(viwe_listner);
    }
    public void addDotsIndictor(int position)
    {
        Dots=new TextView[5];
        for (int i = 0; i <Dots.length ; i++) {
            Dots[i]=new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226;"));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.gray));
            dots.addView(Dots[i]);
        }
        if (Dots.length>0)
        {
            Dots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
    ViewPager.OnPageChangeListener viwe_listner=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }


        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i <Dots.length ; i++) {
                dots.removeView(Dots[i]);
            }
            addDotsIndictor(position);
            current_page=position;
            if (position==0)
            {
                next_button.setEnabled(true);
                back_button.setEnabled(false);
                back_button.setVisibility(View.INVISIBLE);
                next_button.setText("Next");
                back_button.setText("");

            }
            else if (position==Dots.length-1)
            {
                next_button.setEnabled(true);
                back_button.setEnabled(true);
                back_button.setVisibility(View.VISIBLE);
                next_button.setText("Finish");
                back_button.setText("Back");

            }
            else
            {
                next_button.setEnabled(true);
                back_button.setEnabled(true);
                back_button.setVisibility(View.VISIBLE);
                next_button.setText("Next");
                back_button.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void onBackPressed() {
        Intent intent2 = new Intent(Achievement.this, MainActivity.class);
        startActivity(intent2);
    }
}