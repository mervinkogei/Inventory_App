package com.custom.inventoryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.custom.inventoryapp.R;
import com.custom.inventoryapp.database.Inventory;

import java.util.List;

public class InventoryListAdapter extends RecyclerView.Adapter <InventoryListAdapter.MyViewHolder>{

    private final Context context;
    private List<Inventory> inventoryList;

    public InventoryListAdapter(Context context){
        this.context = context;
    }

    public void setInventoryList(List<Inventory> inventoryList){
        this.inventoryList = inventoryList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public InventoryListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_recycler_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryListAdapter.MyViewHolder holder, int position) {
        holder.tvname.setText(this.inventoryList.get(position).product_name);
        holder.tvprice.setText(this.inventoryList.get(position).price);
        holder.tvtype.setText(this.inventoryList.get(position).product_type);
    }

    @Override
    public int getItemCount() {
        return this.inventoryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname;
        TextView tvtype;
        TextView tvprice;

        public MyViewHolder(View view){
            super(view);
             tvname = view.findViewById(R.id.tvname);
             tvtype = view.findViewById(R.id.tvtype);
             tvprice = view.findViewById(R.id.tvprice);
        }
    }
}
