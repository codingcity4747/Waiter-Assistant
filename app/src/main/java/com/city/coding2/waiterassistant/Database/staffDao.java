package com.city.coding2.waiterassistant.Database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface staffDao {

    @Insert
     void insert(staff s);

    @Update
     void update(staff s);

    @Delete
     void delete(staff s);

    @Query("DELETE  FROM staff_table")
     void deleteAllStaff();

    @Query("SELECT * FROM staff_table ORDER BY staff_name DESC")
    LiveData<List<staff>> selectAllStaff();
}
