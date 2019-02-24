package com.city.coding2.waiterassistant;

import com.city.coding2.waiterassistant.Database.table;

import java.util.ArrayList;

public class dumData {



    public ArrayList<table> setAndGetTableInfo(int tableNum){
        ArrayList<table> tableInfo = new ArrayList<>();
        for(int i =0 ; i<tableNum ;i++){
            table t = new table(i+1,i*2,10,true);
        }
        return tableInfo;
    }

}
