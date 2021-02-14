package com.example.benchmark.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmark.R;
import com.example.benchmark.controller.Adapter;
import com.example.benchmark.controller.TestManager;
import com.example.benchmark.model.Test;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private List<Test> testList = new ArrayList<>();
    private Adapter mAdapter;
    private TestManager testManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_history, container, false);


        RecyclerView recyclerView = root.findViewById(R.id.tests_list);
        testList.clear();
        mAdapter = new Adapter(testList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        testManager = TestManager.getInstance(getActivity());
        testList.addAll(testManager.getTests());
        mAdapter.notifyDataSetChanged();

        return root;
    }


}