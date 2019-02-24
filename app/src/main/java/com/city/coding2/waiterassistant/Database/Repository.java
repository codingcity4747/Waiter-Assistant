package com.city.coding2.waiterassistant.Database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repository {
    private tableDao tableDao;
    private staffDao staffDao;
    private LiveData<List<table>>alltables;
    private LiveData<List<staff>>allStaff;


    public Repository (Application application){
        waiterDatabase db = waiterDatabase.getDatabaseInstance(application);
        tableDao = db.tableDao();
        staffDao = db.staffDao();
        alltables = tableDao.getAllTables();
    }

    //insert new table
    private void insertNewTable(table t){
        new insertTableAsynctask(tableDao).execute(t);
    }

    //update table
    private void updateTable(table t){
        new updateTableAsynctask(tableDao).execute(t);
    }

    //delete specific table
    private void deleteTable(int tableNum){
        new deleteTableNum(tableDao).execute(tableNum);
    }

    //delete All tables
    private void deleteAllTables(){
        new deleteAllTables(tableDao).execute();
    }

    //select all talbes
    private LiveData<List<table>> selectAllTalbes(){
        return alltables;
    }

    /*******Aynctask classes for table queries*******/

    //insert Asynktask
    private static class insertTableAsynctask extends AsyncTask<table,Void,Void>{
        private tableDao tableDao;
        private insertTableAsynctask(tableDao tableDao){
            this.tableDao = tableDao;
        }
        @Override
        protected Void doInBackground(table... tables) {
            tableDao.insertTable(tables[0]);
            return null;
        }
    }

    //update Asynctask
    private static class updateTableAsynctask extends AsyncTask<table,Void,Void>{
        private tableDao tableDao ;

        private updateTableAsynctask(tableDao tableDao){
            this.tableDao = tableDao;
        }
        @Override
        protected Void doInBackground(table... tables) {
            tableDao.updateTable(tables[0]);
            return null;
        }
    }

    //delete specific table with it's number
    private static class deleteTableNum extends AsyncTask<Integer,Void,Void>{
       private tableDao tableDao ;

        private deleteTableNum(tableDao tableDao){
            this.tableDao = tableDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            tableDao.deleteTableNum(integers[0]);
            return null;
        }
    }

    //delete all tables
    private static class deleteAllTables extends AsyncTask<Void,Void,Void>{
        private tableDao tableDao;

        private deleteAllTables(tableDao tableDao){
            this.tableDao = tableDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            tableDao.deleteAllTables();
            return null;
        }
    }
}
