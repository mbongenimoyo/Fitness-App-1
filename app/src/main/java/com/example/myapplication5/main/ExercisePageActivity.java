package com.example.myapplication5.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myapplication5.R;

public class ExercisePageActivity extends AppCompatActivity {

    TextView mName,mPageNum,mDescription;
    ImageView mImage;
    Button next_button, prev_button;


    int[] images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page);

        Intent intent=this.getIntent();


        String name=intent.getStringExtra("exerciseName");
        mName=findViewById(R.id.exercise_page_header);
        mName.setText(name);

        mImage= findViewById(R.id.exercise_page_image);
        mPageNum= findViewById(R.id.exercise_page_text);
        mDescription = findViewById(R.id.description_box);
        setUpImageview();



        final String[] description = intent.getStringArrayExtra("exerciseDesc");
        images = intent.getIntArrayExtra("exerciseImages");
        System.out.println("please help T_T");


        next_button=findViewById(R.id.next_button);
        prev_button=findViewById(R.id.previous_button);
        prev_button.setText("<");
        next_button.setText(">");
        mImage.setImageResource(images[0]);
        mDescription.setText(description[0]);
        mPageNum.setText("1/2");
//        next_button.setBackgroundDrawable(ContextCompat.getDrawable(context,R.drawable.button_exercise_page_enabled));
//        prev_button.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.button_exercise_page_disabled));

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mImage.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.easy_1_image));
                mImage.setImageResource(images[0]);

                next_button.setEnabled(false);
                prev_button.setEnabled(true);
                mPageNum.setText("2/2");

                next_button.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.button_exercise_page_disabled));
                prev_button.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.button_exercise_page_enabled));
                mDescription.setText(description[1]);


            }
        });

        prev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mImage.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.easy_1_image));
                mImage.setImageResource(images[1]);
                mImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                mPageNum.setText("1/2");
                next_button.setEnabled(true);
                prev_button.setEnabled(false);
                next_button.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.button_exercise_page_enabled));
                prev_button.setBackgroundDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.button_exercise_page_disabled));

                mDescription.setText(description[0]);


            }
        });
    }

    public void setUpImageview(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        LinearLayout.LayoutParams imageParams =new LinearLayout.LayoutParams(width-(width/8),height/2);
        imageParams.setMargins((width/8)/2,25,0,25);
        mImage.setLayoutParams(imageParams);

        int y =mImage.getMeasuredWidth();

    }


}
