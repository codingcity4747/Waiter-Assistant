package com.city.coding2.waiterassistant;

import android.app.Application;
import android.nfc.Tag;
import android.util.Log;

import com.city.coding2.waiterassistant.Database.Repository;
import com.city.coding2.waiterassistant.Database.table;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class viewModel extends AndroidViewModel {
    public static String TAG = "viewModel";
    private Repository repository;
    private LiveData<List<table>> alltables;
    public viewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "viewModel() called with: application = [" + application + "]");
        repository = new Repository(application);
        alltables= repository.selectAllTalbes();
    }

    /*table repo methods*/
    //insert
    public void insert(table t ){
        repository.insertNewTable(t);
    }
    //update
    public void update(table t){
        repository.updateTable(t);
    }
    //delete table
    public void deleteTable(int num){
        repository.deleteTable(num);
    }

    //delete all table
    public void deleteAllTable(){
        repository.deleteAllTables();
    }
    //select all table
    public LiveData<List<table>>selectAllTable(){
        Log.d(TAG, "selectAllTable: return all tables from database ");
        return alltables;
    }

    //update tableStatus
    public void updateTableStatus(boolean tableStatus){
        repository.updateTableStatus(tableStatus);
    }
}
