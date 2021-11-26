package com.example.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.Item;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Item> orders;
    Context context;

    public MyAdapter(Context context, ArrayList<Item> orders) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(orders.get(position).getItemImageId());
        holder.itemName.setText(orders.get(position).getItemName());
        holder.itemQty.setText(String.valueOf(orders.get(position).getItemQty()));
        holder.itemPrice.setText(new StringBuilder().append("Rp ").append(
                orders.get(position).getItemPrice().toString()).toString()
        );
    }

    @Override
    public int getItemCount() {
        Log.d("ADAPTER_ORDERS", String.valueOf(orders.size()));
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName, itemPrice, itemQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemImage = itemView.findViewById(R.id.img_item_view);
            this.itemName = itemView.findViewById(R.id.cartItemName);
            this.itemPrice = itemView.findViewById(R.id.cartItemPrice);
            this.itemQty = itemView.findViewById(R.id.cartQty);
        }
    }
}
