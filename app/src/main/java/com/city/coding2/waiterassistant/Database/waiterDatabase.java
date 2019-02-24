package com.city.coding2.waiterassistant.Database;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.city.coding2.waiterassistant.MainActivity;
import com.city.coding2.waiterassistant.dumData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {table.class,staff.class},version =1 ,exportSchema= false)
public abstract class waiterDatabase extends RoomDatabase {
    private static waiterDatabase instance;

    public abstract staffDao staffDao() ;
    public abstract tableDao tableDao();


    public static synchronized waiterDatabase getDatabaseInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    waiterDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private staffDao staffDao;
        private tableDao tableDao;
        private ArrayList<table> tables;
        private ArrayList<staff> staff;
        private PopulateDbAsyncTask(waiterDatabase db) {
            staffDao = db.staffDao();
            tableDao = db.tableDao();
            dumData d = new dumData();
            tables =  d.setAndGetTableInfo(10);
            staff = d.setAndGetStaffInfo();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for(int i = 0 ; i<tables.size();i++)
            {
                tableDao.insertTable(tables.get(i));
                staffDao.insert(staff.get(i));
            }
            return null;
        }
    }


}
