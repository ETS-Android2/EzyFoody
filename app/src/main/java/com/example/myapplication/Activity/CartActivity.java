package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Item> cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart = getIntent().getParcelableArrayListExtra("CART");
        Log.d("CART_ITEM_ORDER", String.valueOf(cart.size()));

        for (Item item: cart) {
            Log.d("CART_ON_CART_ACTIVITY", item.getItemName() + ' ' + item.getItemQty());
        }
    }
}