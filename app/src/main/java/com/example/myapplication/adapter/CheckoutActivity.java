package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.activity.Item;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CheckoutActivity extends RecyclerView.Adapter<CheckoutActivity.ViewHolder> {

    ArrayList<Item> orders;
    Context context;

    public CheckoutActivity(Context context, ArrayList<Item> orders) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.checkout_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(orders.get(position).getItemImageId());
        holder.itemName.setText(orders.get(position).getItemName());
        holder.itemQty.setText(String.valueOf(orders.get(position).getItemQty()));
        holder.itemPrice.setText("Rp " +
                orders.get(position).getItemPrice().toString()
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
            this.itemImage = itemView.findViewById(R.id.img_complete_item_view);
            this.itemName = itemView.findViewById(R.id.completeItemName);
            this.itemPrice = itemView.findViewById(R.id.completeItemPrice);
            this.itemQty = itemView.findViewById(R.id.completeItemQty);
        }
    }
}
