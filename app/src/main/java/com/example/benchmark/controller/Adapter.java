package com.example.benchmark.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmark.R;
import com.example.benchmark.model.Test;
import com.example.benchmark.utills.DateUtils;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Test> testList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, score, date;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_element);
            score = view.findViewById(R.id.score_element);
            date = view.findViewById(R.id.date_element);
        }
    }

    public Adapter(List<Test> testList) {
        this.testList = testList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_test, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Test test = testList.get(position);
        holder.name.setText('[' + test.getCategory() + "]  " + test.getTypeOfTest());
        holder.score.setText(String.valueOf(test.getScore()));
        holder.date.setText(DateUtils.milliToDate(test.getDate()));
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }
}