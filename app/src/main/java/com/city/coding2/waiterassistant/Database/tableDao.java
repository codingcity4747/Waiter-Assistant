package com.city.coding2.waiterassistant.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface tableDao {

    @Insert
     void insertTable(table t);

    @Update
     void updateTable(table t);

    @Delete
     void deleteTable(table t);

    @Query("DELETE FROM tables_table WHERE table_number = :tableNum")
     void deleteTableNum(int tableNum);


}
