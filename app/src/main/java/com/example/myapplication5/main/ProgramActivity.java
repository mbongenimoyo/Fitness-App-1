package com.example.myapplication5.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Programs.Easy_program_1;
import com.example.myapplication5.main.Programs.Easy_program_2;
import com.example.myapplication5.main.Programs.Hard_program_1;
import com.example.myapplication5.main.Programs.Hard_program_2;
import com.example.myapplication5.main.Programs.Med_program_1;
import com.example.myapplication5.main.Programs.Med_program_2;
import com.example.myapplication5.main.Programs.Program;
import com.example.myapplication5.main.Routine.Routine;

import java.util.ArrayList;

public class ProgramActivity extends AppCompatActivity {

    private RecyclerView mRoutineList;
    private RecyclerView.Adapter mRoutineListAdapter;
    private RecyclerView.LayoutManager mGetRoutineListLayoutManager;
    ArrayList<Routine> routineList;
    TextView mName;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_page);
        routineList = new ArrayList<>();
        Intent intent = this.getIntent();
        //mProgress= findViewById(R.id.pBar);
        String name= intent.getStringExtra("programName");
        mName=findViewById(R.id.program_title);
        mName.setText(name.toUpperCase());
        Program f;
        if(name.equals("Beginner program 1")){
            f= new Easy_program_2(this);
        }
        else if (name.equals("Beginner program 2")){
            f= new Easy_program_1(this);
        }
        else if (name.equals("Medium program 1")){
            f= new Med_program_1(this);
        }
        else if (name.equals("Advanced program 1")){
            f= new Hard_program_1(this);
        }
        else if (name.equals("Advanced program 2")){
            f= new Hard_program_2(this);
        }
        else {
            f= new Med_program_2(this);
        }



        //Easy_program_1 e= new Easy_program_1();
        routineList=f.getRoutines();
//        Exercise crunch= new crunches(10);
//        Exercise legRaises =new LegRaises();
//        Exercise twistCrunch = new TwistingCrunches();
//        Exercise sitUps = new SitUp();
//        Exercise inAndOut = new InAndOutSitUps();
//        Exercise planks = new Planks();



        initializeRecyclerView();
        //updateProgress();

       // getExerciseList();

    }

//    private void updateProgress() {
//        //mProgress.setProgress(20);
//        for(Routine e:routineList){
//            if(e.getCheckComplete()[0]){
//                mRoutineList.get
//                mProgress.incrementProgressBy(1);
//
//            }
//        }
//    }


    private void getExerciseList() {


        mRoutineListAdapter.notifyDataSetChanged();

    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        mRoutineList = findViewById(R.id.routineList);
        mRoutineList.setNestedScrollingEnabled(false);
        mRoutineList.setHasFixedSize(false);
        mGetRoutineListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL ,false);
        mRoutineList.setLayoutManager(mGetRoutineListLayoutManager);
        mRoutineListAdapter = new RoutineListAdapter(routineList);

        mRoutineList.setAdapter(mRoutineListAdapter);
    }
}
