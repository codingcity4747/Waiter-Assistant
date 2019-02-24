package com.city.coding2.waiterassistant.Database;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.city.coding2.waiterassistant.MainActivity;
import com.city.coding2.waiterassistant.dumData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {table.class}, version = 1, exportSchema = false)
public abstract class waiterDatabase extends RoomDatabase {
    public static String TAG = "waiterDatabase";
    private static waiterDatabase instance;

    public abstract tableDao tableDao();


    public static synchronized waiterDatabase getDatabaseInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    waiterDatabase.class, "table_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            Log.e(TAG, "onCreate: database created");
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private tableDao tableDao;


        private PopulateDbAsyncTask(waiterDatabase db) {
            Log.e(TAG, "PopulateDbAsyncTask: create Dao references");
            tableDao = db.tableDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            tableDao.insertTable(new table(1,5,10,true,false,false,"none"));

            tableDao.insertTable(new table(2,6,10,true,false,false,"none"));

            tableDao.insertTable(new table(3,7,10,true,false,false,"none"));
            return null;
        }
    }


}
