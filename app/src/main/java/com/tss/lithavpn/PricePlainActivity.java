package com.tss.lithavpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PricePlainActivity extends AppCompatActivity {
    ViewPager viewPager;
    SlideViewPagerAdapter adapter;
    List<PlainModels> plainModelsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_plain);
        viewPager = findViewById(R.id.viewpg_id);
        plainModelsList = new ArrayList<>();
        plainModelsList.add(new PlainModels("3 Month Plain","7 days free trial give you full access to our premium features","only $100"));
        plainModelsList.add(new PlainModels("6 Month Plain","7 days free trial give you full access to our premium features","only $300"));
        plainModelsList.add(new PlainModels("9 Month Plain","7 days free trial give you full access to our premium features","only $600"));
        adapter=new SlideViewPagerAdapter(this,plainModelsList);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        tabLayout.setupWithViewPager(viewPager, true);
    }
}