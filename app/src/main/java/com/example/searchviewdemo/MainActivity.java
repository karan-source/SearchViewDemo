package com.example.searchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private SearchView sv;
    private ArrayList search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find view by id
        lv = findViewById(R.id.lv);
        sv = findViewById(R.id.sv);
        search = new ArrayList();
        search.add("Apple");
        search.add("Mango");
        search.add("Banana");
        search.add("Orange");
        search.add("Guava");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, search);
        lv.setAdapter(arrayAdapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (search.contains(query)) {
                    arrayAdapter.getFilter().filter(query);
                } else
                    Toast.makeText(MainActivity.this, "Match not found", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
