package com.example.mam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class slider_adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public slider_adapter(Context context)
    {
        this.context=context;
    }
    //Arrayes
    public int[] slide_images={
        R.drawable.computerscience,R.drawable.garden
    ,R.drawable.wall,R.drawable.lecture,R.drawable.library};
    public String[] Heading={
            "الأستقبال المركزي","الأستقبال 5","حواس "," تاج"
            ," معسكر"};
    public String[] Description={
            "عملنا اول استقبال للطلاب الوافدين","22222222222222222","3333333333333 "," 44444444444444444444444"
            ,"555555555555"};
    @Override
    public int getCount() {
        return Heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout) object;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider,container,false);
        ImageView slideimageview =(ImageView) view.findViewById(R.id.slide_image);
        TextView head =(TextView) view.findViewById(R.id.slide_heading);
        TextView desc =(TextView) view.findViewById(R.id.slide_description);
        slideimageview.setImageResource(slide_images[position]);
        head.setText(Heading[position]);
        desc.setText(Description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
