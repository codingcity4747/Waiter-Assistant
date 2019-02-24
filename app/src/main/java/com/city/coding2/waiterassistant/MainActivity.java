package com.city.coding2.waiterassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.city.coding2.waiterassistant.Adapter.tableAdapter;
import com.city.coding2.waiterassistant.Database.table;
import com.city.coding2.waiterassistant.Database.waiterDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private viewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_id);
        

        final tableAdapter adapter = new tableAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(viewModel.class);
        viewModel.selectAllTable().observe(this, new Observer<List<table>>() {
            @Override
            public void onChanged(List<table> tables) {
                Toast.makeText(MainActivity.this, "onChange", Toast.LENGTH_SHORT).show();
                adapter.setTables(tables);
            }
        });
        //TODO: popup a dialog box to get the intial number of tables
        //TODO: manage table number and make it auto genereted, for queries purpose

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
