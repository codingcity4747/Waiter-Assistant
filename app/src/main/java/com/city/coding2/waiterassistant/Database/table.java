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

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public void setIs_join(boolean is_join) {
        this.is_join = is_join;
    }

    public void setJoin_with(String join_with) {
        this.join_with = join_with;
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

    public table(int tableNum, int tableGuestNum, int tableCapacity, boolean tableState
                  , boolean is_locked, boolean is_join, String join_with) {
        this.table_number = tableNum;
        this.guest_number = tableGuestNum;
        this.table_capacity = tableCapacity;
        this.table_status = tableState;
        this.is_locked = is_locked;
        this.is_join= is_join;
        this.join_with = join_with;
    }

    public int getTableNum() {
        return table_number;
    }

    public int getTableGuestNum() {
        return guest_number;
    }

    public int getTableCapacity() {
        return table_capacity;
    }

    public boolean isTableState() {
        return table_status;
    }

    public void setTableNum(int tableNum) {
        this.table_number = tableNum;
    }

    public void setTableGuestNum(int tableGuestNum) {
        this.guest_number = tableGuestNum;
    }

    public void setTableCapacity(int tableCapacity) {
        this.table_capacity = tableCapacity;
    }

    public void setTableState(boolean tableState) {
        this.table_status = tableState;
    }
}
