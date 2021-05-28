package com.hypech.case21_recyclerview_core;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HypechRecyclerViewAdapter.ItemClickListener {

    HypechRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 1. populate data into ArrayList for the RecyclerView

        ArrayList<String> arrayListName = new ArrayList<>();
        arrayListName.add("Megan Fox");
        arrayListName.add("Scarlett Johansson");
        arrayListName.add("Jessica Alba");
        arrayListName.add("Katge Upton");
        arrayListName.add("Keira Knightley");
        arrayListName.add("Jennifer Lawrence");

        // 2. set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HypechRecyclerViewAdapter(this, arrayListName);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}