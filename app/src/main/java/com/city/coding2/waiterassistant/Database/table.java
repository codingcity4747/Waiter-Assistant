package com.city.coding2.waiterassistant.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "tables_table")
public class table {

    @PrimaryKey (autoGenerate = true)
    private int id ;

    private int table_number;

    private int guest_number ;

    private int table_capacity;

    private boolean table_status;

    private boolean is_locked;

    private boolean is_join ;

    private String join_with ;


    public table(int table_number, int guest_number, int table_capacity,
                 boolean table_status, boolean is_locked, boolean is_join,
                 String join_with) {
        this.table_number = table_number;
        this.guest_number = guest_number;
        this.table_capacity = table_capacity;
        this.table_status = table_status;
        this.is_locked = is_locked;
        this.is_join = is_join;
        this.join_with = join_with;
    }

    public int getId() {
        return id;
    }

    public int getTable_number() {
        return table_number;
    }

    public int getGuest_number() {
        return guest_number;
    }

    public int getTable_capacity() {
        return table_capacity;
    }

    public boolean isTable_status() {
        return table_status;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public boolean isIs_join() {
        return is_join;
    }

    public String getJoin_with() {
        return join_with;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public void setGuest_number(int guest_number) {
        this.guest_number = guest_number;
    }

    public void setTable_capacity(int table_capacity) {
        this.table_capacity = table_capacity;
    }

    public void setTable_status(boolean table_status) {
        this.table_status = table_status;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public void setIs_join(boolean is_join) {
        this.is_join = is_join;
    }

    public void setJoin_with(String join_with) {
        this.join_with = join_with;
    }
}
