package com.city.coding2.waiterassistant.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="staff_table")
public class staff {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String staff_name ;
    private int staff_pin ;
    private String staff_phone;
    private String staff_address;
    private String staff_id;

    public staff(String staff_name, int staff_pin, String staff_phone, String staff_address, String staff_id) {
        this.staff_name = staff_name;
        this.staff_pin = staff_pin;
        this.staff_phone = staff_phone;
        this.staff_address = staff_address;
        this.staff_id = staff_id;
    }

    public int getId() {
        return id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public int getStaff_pin() {
        return staff_pin;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setStaff_pin(int staff_pin) {
        this.staff_pin = staff_pin;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
}
