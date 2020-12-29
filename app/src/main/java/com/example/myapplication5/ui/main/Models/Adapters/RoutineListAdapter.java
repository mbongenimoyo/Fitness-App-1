//package com.example.myapplication5.ui.main.Models.Adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication5.R;
//import com.example.myapplication5.ui.main.Models.RoutineModel;
//
//import java.util.ArrayList;
//
//public class RoutineListAdapter extends RecyclerView.Adapter<RoutineListAdapter.RoutineListViewHolder> {
//
//    private ArrayList<RoutineModel> routineList;
//
//    public RoutineListAdapter(ArrayList<RoutineModel> routineList){
//        this.routineList=routineList;
//    }
//
//    @NonNull
//    @Override
//    public RoutineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_fragment, null,false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutView.setLayoutParams(lp);
//        RoutineListViewHolder rcv = new RoutineListViewHolder(layoutView);
//        return rcv;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RoutineListViewHolder holder, int position) {
//
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class RoutineListViewHolder extends RecyclerView.ViewHolder{
//        public TextView mTitle ;
//        public LinearLayout mLayout;
//
//
//        public RoutineListViewHolder(View view){
//            super(view);
//
//        }
//    }
//}
