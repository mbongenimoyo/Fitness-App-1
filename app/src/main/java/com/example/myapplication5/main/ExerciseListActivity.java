package com.example.myapplication5.main;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.database.EasyProgram1DbHandler;
import com.example.myapplication5.main.database.EasyProgram2DbHandler;
import com.example.myapplication5.main.exercises.Bicycle;
import com.example.myapplication5.main.exercises.InAndOutSitUps;
import com.example.myapplication5.main.exercises.KneeToElbow;
import com.example.myapplication5.main.exercises.LegRaises;
import com.example.myapplication5.main.exercises.Planks;
import com.example.myapplication5.main.exercises.SidePlanks;
import com.example.myapplication5.main.exercises.SitUp;
import com.example.myapplication5.main.exercises.ToeTaps;
import com.example.myapplication5.main.exercises.TwistingCrunches;
import com.example.myapplication5.main.exercises.crunches;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class ExerciseListActivity extends AppCompatActivity {
    private RecyclerView mExerciseList;
    private RecyclerView.Adapter mExerciseListAdapter;
    private RecyclerView.LayoutManager mGetExerciseListLayoutManager;
    ArrayList<Exercise> exerciseList;

    InterstitialAd mInterstitialAd;
    ImageView mButton;



    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list_page);
        exerciseList = new ArrayList<>();

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        EasyProgram1DbHandler db = new EasyProgram1DbHandler(this);
       // EasyProgram2DbHandler db2 = new EasyProgram2DbHandler(this);
        Exercise crunch= new crunches(10);
        Exercise legRaises =new LegRaises();
        Exercise twistCrunch = new TwistingCrunches();
        Exercise sitUps = new SitUp();
        Exercise inAndOut = new InAndOutSitUps();
        Exercise planks = new Planks(10,"seconds");

        //db.insertExercise(planks.getName(),planks.getType(),"Easy_program_1",1,planks.getReps(),planks.getDescription()[0],planks.getDescription()[1],false);

        exerciseList.add(crunch);
        exerciseList.add(legRaises);
        exerciseList.add(twistCrunch);
        exerciseList.add(sitUps);
        exerciseList.add(inAndOut);
        exerciseList.add(planks);
        exerciseList.add(new SidePlanks());
        exerciseList.add(new Bicycle());
        exerciseList.add(new KneeToElbow());
        exerciseList.add(new ToeTaps());


        Cursor res=db.getRoutines();
        StringBuffer buf= new StringBuffer();
        ArrayList<String> arr = new ArrayList<>();
        while(res.moveToNext()){
            arr.add(res.getString(2));
        }
        System.out.println(arr);

        initializeRecyclerView();
        getExerciseList();
        System.out.println("please help T_T");
    }

    private void getExerciseList() {


        mExerciseListAdapter.notifyDataSetChanged();

    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        mExerciseList = findViewById(R.id.exerciseList);
        mExerciseList.setNestedScrollingEnabled(false);
        mExerciseList.setHasFixedSize(false);
        mGetExerciseListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL ,false);
        mExerciseList.setLayoutManager(mGetExerciseListLayoutManager);
        mExerciseListAdapter = new ExerciseListAdapter(exerciseList);
        mExerciseList.setAdapter(mExerciseListAdapter);
    }


}
