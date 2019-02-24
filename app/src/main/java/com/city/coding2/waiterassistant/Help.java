package com.city.coding2.waiterassistant;

import android.content.Context;

import com.city.coding2.waiterassistant.R;

public class Help {

    public static int checkTableAvaliblity(boolean tableStatus, Context context){
        int green = context.getResources().getColor(R.color.tableAvalibleBG);
        int red = context.getResources().getColor(R.color.tableNotAvalibleBG);
        if(tableStatus==true){
            return  green;
        }
        return red;
    }
}
