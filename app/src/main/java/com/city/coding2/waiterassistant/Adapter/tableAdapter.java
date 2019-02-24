package com.city.coding2.waiterassistant.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.city.coding2.waiterassistant.Database.Repository;
import com.city.coding2.waiterassistant.Database.table;
import com.city.coding2.waiterassistant.Help;
import com.city.coding2.waiterassistant.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class tableAdapter extends RecyclerView.Adapter<tableAdapter.viewHolder> {

    private Repository repository ;
    private static final String TAG = "tableAdapter";
    private List<table> tables = new ArrayList<>();
    private Context context ;
    private String table,guest;

    public tableAdapter(Context context){
        this.context = context;
        table = context.getResources().getString(R.string.tableNum)+": ";
        guest = context.getResources().getString(R.string.guestNum)+": ";
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View item = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.table,parent ,false);
        return new viewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        table current = tables.get(position);
        Log.d(TAG, "onBindViewHolder: "+current.isTable_status());
        boolean tableStatus = current.isTable_status();
        int color = Help.checkTableAvaliblity(tableStatus,context);
        holder.tableNum.setText(table+current.getTable_number());
        holder.guestNum.setText(guest+current.getGuest_number());
        holder.tableCardView.setCardBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }


    //set table list
    public void setTables (List<table> tables){
        this.tables= tables;
        notifyDataSetChanged();
    }
    class viewHolder extends RecyclerView.ViewHolder{

        TextView tableNum,guestNum;
        CardView tableCardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tableNum = itemView.findViewById(R.id.tableNum_id);
            guestNum = itemView.findViewById(R.id.guestNum_id);
            tableCardView = itemView.findViewById(R.id.table_cardView_id);
        }
    }
}
