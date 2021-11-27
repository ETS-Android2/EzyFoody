package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.activity.CartActivity;
import com.example.myapplication.activity.Item;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Item> orders;
    Context context;

    public CartAdapter(Context context, ArrayList<Item> orders) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_item_view, parent, false);

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemImage;
        TextView itemName, itemPrice, itemQty;
        Button btnRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemImage = itemView.findViewById(R.id.img_item_view);
            this.itemName = itemView.findViewById(R.id.cartItemName);
            this.itemPrice = itemView.findViewById(R.id.cartItemPrice);
            this.itemQty = itemView.findViewById(R.id.cartQty);
            this.btnRemove = itemView.findViewById(R.id.btn_delete);

            btnRemove.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("View: ", v.toString());
            if (v.equals(btnRemove)) {
                removeAt(getAdapterPosition());
            }
            Intent i = new Intent(context, CartActivity.class);
            i.putParcelableArrayListExtra("CART", orders);
            context.startActivity(i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
        }

        public void removeAt(int position) {
            orders.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, orders.size());
        }
    }
}
