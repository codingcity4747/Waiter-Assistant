package com.city.coding2.waiterassistant;

import com.city.coding2.waiterassistant.Database.staff;
import com.city.coding2.waiterassistant.Database.table;

import java.util.ArrayList;

public class dumData {



    public ArrayList<table> setAndGetTableInfo(int tableNum){
        ArrayList<table> tableInfo = new ArrayList<>();
        ArrayList<staff> staffInfo = new ArrayList<>();

        for(int i =0 ; i<tableNum ;i++){
            table t = new table(i+1,0,10,false,
                    false,false,"none");
            tableInfo.add(t);
        }
        return tableInfo;
    }


    public ArrayList<staff> setAndGetStaffInfo(){
        ArrayList<staff> staffInfo = new ArrayList<>();
        staffInfo.add(new staff("ahmed",123,"1123458","abc st","12dfsd2"));
        staffInfo.add(new staff("Ali",456,"651651","konashi st","sdf4dsf4"));
        staffInfo.add(new staff("Kao",789,"583458","takouto st","23df6"));
        return staffInfo;
    }

}
