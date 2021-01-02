package com.example.myapplication5.ui.main;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication5.InfoActivity;
import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;
import com.example.myapplication5.main.ExerciseListActivity;
import com.example.myapplication5.main.ExerciseListAdapter;
import com.example.myapplication5.main.ProgramActivity;
import com.example.myapplication5.main.ProgramAdapter;
import com.example.myapplication5.main.Programs.Easy_program_1;
import com.example.myapplication5.main.Programs.Easy_program_2;
import com.example.myapplication5.main.Programs.Hard_program_1;
import com.example.myapplication5.main.Programs.Hard_program_2;
import com.example.myapplication5.main.Programs.Med_program_1;
import com.example.myapplication5.main.Programs.Med_program_2;
import com.example.myapplication5.main.Programs.Program;
import com.example.myapplication5.main.database.EasyProgram1DbHandler;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import static com.example.myapplication5.R.drawable.*;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    //InterstitialAd mInterstitialAd ;
    private RecyclerView mProgramList;
    private RecyclerView.Adapter mProgramListAdapter;
    private RecyclerView.LayoutManager mGetExerciseListLayoutManager;
    ArrayList<Program> programList= new ArrayList<>();

    //EasyProgram1DbHandler db= new EasyProgram1DbHandler(this.getContext());

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
       // final ImageView imageView = getView().findViewById(R.id.home_image);
        final TextView mExercises= getView().findViewById(R.id.dif_easy);
        final TextView mInfo= getView().findViewById(R.id.info);
        AdView mAdView = getView().findViewById(R.id.bannerAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //final TextView mHard= getView().findViewById(R.id.dif_hard);
        programList.add(new Easy_program_1(getContext()));
        programList.add(new Easy_program_2(getContext()));
        programList.add(new Med_program_1(getContext()));
        programList.add(new Med_program_2(getContext()));
        programList.add(new Hard_program_1(getContext()));
        programList.add(new Hard_program_2(getContext()));


        initializeRecyclerView();



        
       //InitialiseDiffulty();
        RecyclerView mRecycler = getView().findViewById(R.id.routineList);

       //mRecycler.setAdapter();


        mExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageView.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mEasy.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple_diffulty_button ));
//                mMed.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mHard.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
                startActivity(new Intent(getActivity().getApplicationContext(), ExerciseListActivity.class));
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageView.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mEasy.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple_diffulty_button ));
//                mMed.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mHard.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
                startActivity(new Intent(getActivity().getApplicationContext(), InfoActivity.class));
            }
        });

//        mMed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // imageView.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mEasy.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple ));
//                mMed.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple_diffulty_button ));
//                mHard.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//            }
//        });

//        mHard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // imageView.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mEasy.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple ));
//                mMed.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                mHard.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple_diffulty_button));
//
////                Cursor res=db.getRoutines();
////                StringBuffer buf= new StringBuffer();
////                ArrayList<String> arr = new ArrayList<>();
////                while(res.moveToNext()){
////                    arr.add(res.getString(1));
////                }
////                System.out.println(arr);
//            }
//        });

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                imageView.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
////                mEasy.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple_diffulty_button ));
////                mMed.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
////                mHard.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), header_background_purple));
//                startActivity(new Intent(getActivity().getApplicationContext(), ProgramActivity.class));
//            }
//        });

    };


    public void RoundImageView(ImageView imageView){
//        Bitmap mbitmap= ((BitmapDrawable)getResources().getDrawable(easy_1_image)).getBitmap();
//
//        Bitmap imageRounded=Bitmap.createBitmap(mbitmap.getWidth(),mbitmap.getHeight(),mbitmap.getConfig());
//        Canvas canvas = new Canvas(imageRounded);
//        Paint mpaint=new Paint();
//        mpaint.setAntiAlias(true);
//        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        canvas.drawRoundRect((new RectF(30, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint); // Round Image Corner 100 100 100 100
//        imageView.setImageBitmap(imageRounded);


    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        mProgramList = getView().findViewById(R.id.programList);
        mProgramList.setNestedScrollingEnabled(false);
        mProgramList.setHasFixedSize(false);
        mProgramList.setItemViewCacheSize(6);
        mProgramList.setDrawingCacheEnabled(true);
        mProgramList.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_AUTO);
        mGetExerciseListLayoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL ,false);
        mProgramList.setLayoutManager(mGetExerciseListLayoutManager);
        mProgramListAdapter = new ProgramAdapter(programList);
        mProgramList.setAdapter(mProgramListAdapter);
    }



}
