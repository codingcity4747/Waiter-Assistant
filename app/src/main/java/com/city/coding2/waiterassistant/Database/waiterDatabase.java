package com.city.coding2.waiterassistant.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {table.class,staff.class},version =1)
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


}
