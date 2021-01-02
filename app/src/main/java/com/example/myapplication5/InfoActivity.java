package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication5.main.InfoAdapter;
import com.example.myapplication5.main.ProgramAdapter;
import com.example.myapplication5.main.info.AboutPage;
import com.example.myapplication5.main.info.HealthAdvice;
import com.example.myapplication5.main.info.Info;
import com.example.myapplication5.main.info.TheScience;
import com.example.myapplication5.main.info.WhatElse;
import com.example.myapplication5.main.info.WhatIsThereToLose;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    RecyclerView mInfo ;
    RecyclerView.Adapter mInfoAdapter;
    RecyclerView.LayoutManager mGetInfoLayoutManager;
    ArrayList<Info> infoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_info);
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        infoArrayList.add(new AboutPage());
        infoArrayList.add(new TheScience());
        infoArrayList.add(new WhatIsThereToLose());
        infoArrayList.add(new HealthAdvice());
        infoArrayList.add(new WhatElse());

        super.onCreate(savedInstanceState);

        initializeRecyclerView();
       // mInfo=findViewById(R.id.info_recycler);


    }


    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        mInfo = findViewById(R.id.info_recycler);
        mInfo.setNestedScrollingEnabled(false);
        mInfo.setHasFixedSize(false);
        mGetInfoLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL ,false);
        mInfo.setLayoutManager(mGetInfoLayoutManager);
        mInfoAdapter = new InfoAdapter(infoArrayList);
        mInfo.setAdapter(mInfoAdapter);
    }
}