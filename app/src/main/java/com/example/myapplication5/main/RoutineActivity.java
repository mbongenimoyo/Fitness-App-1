package com.example.myapplication5.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.exercises.Planks;
import com.example.myapplication5.main.exercises.RestDay;
import com.example.myapplication5.main.exercises.SitUp;
import com.example.myapplication5.main.exercises.TwistingCrunches;
import com.example.myapplication5.main.exercises.crunches;

import java.util.ArrayList;

public class RoutineActivity extends AppCompatActivity {
    private RecyclerView mExerciseList;
    private TextView mHeader;
    private RecyclerView.Adapter mExerciseListAdapter;
    private RecyclerView.LayoutManager mGetExerciseListLayoutManager;
    ArrayList<Exercise> exerciseList= new ArrayList<Exercise>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list_page);
        Intent intent = this.getIntent();
        Bundle args = intent.getBundleExtra("List");
        int[] reps=args.getIntArray("reps");
        mHeader = findViewById(R.id.Header_title);

        //String []
       // exerciseList =intent.getExtras().getParcelableArrayList("List");
        ArrayList<String> names =args.getStringArrayList("names");
        ArrayList<String> types = args.getStringArrayList("type");
        ArrayList<String> program= args.getStringArrayList("programs");
        ArrayList<Integer> complete= args.getIntegerArrayList("complete");
        ArrayList<Integer> routines = args.getIntegerArrayList("routines");
        mHeader.setText("DAY "+routines.get(0));
        int i=0;
        for(String name:names){
            if(name.equals("Crunches")){
                exerciseList.add(new crunches(reps[i],types.get(i),complete.get(i),program.get(i),routines.get(i)));
            }

            else  if(name.equals("Sit ups")){
                exerciseList.add(new SitUp(reps[i],types.get(i),complete.get(i),program.get(i),routines.get(i)));
            }

            else  if(name.equals("Planks")){
                exerciseList.add(new Planks(reps[i],types.get(i),complete.get(i),program.get(i),routines.get(i)));
            }

            else  if(name.equals("Twisting crunches")){
                exerciseList.add(new TwistingCrunches(reps[i],types.get(i),complete.get(i),program.get(i),routines.get(i)));
            }

            else  if(name.equals("Rest")){
                exerciseList.add(new RestDay(reps[i],types.get(i),complete.get(i),program.get(i),routines.get(i)));
            }
            i++;
        }





        initializeRecyclerView();
       // getExerciseList();



    }

    public void SaveData(){

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
        mExerciseListAdapter = new RoutineExerciseAdapter(exerciseList, this);
        mExerciseList.setAdapter(mExerciseListAdapter);
    }


}
