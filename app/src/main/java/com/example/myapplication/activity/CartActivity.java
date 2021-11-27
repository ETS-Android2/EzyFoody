package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.CartAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ArrayList<Item> cart = new ArrayList<>();
    RecyclerView recyclerView;
    Button btnPayNow;
    TextView tvTotalPrice;
    Integer totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btnPayNow = findViewById(R.id.btn_pay_now);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        cart = getIntent().getParcelableArrayListExtra("CART");

        if(cart != null){
            Log.d("CART_ITEM_ORDER", String.valueOf(cart.size()));
            if (cart.size() == 0){
                Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
                tvTotalPrice.setText("Total : Rp. " + totalPrice.toString());
            }
            else{
                recyclerView = findViewById(R.id.recyclerViewCart);
                CartAdapter adp = new CartAdapter(this, cart);
                recyclerView.setAdapter(adp);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                // Calculate Total
                for (Item item:cart) {
                    int price = item.getItemQty() * item.getItemPrice();
                    totalPrice += price;
                }

                tvTotalPrice.setText("Total : Rp. " + totalPrice.toString());
            }
        }
        else{
            Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
        }

        btnPayNow.setOnClickListener(view -> {
            Intent i = new Intent(getApplication(), CheckoutActivity.class);
            i.putParcelableArrayListExtra("CART", cart);
            i.putExtra("TOTAL_PRICE", totalPrice);
            startActivity(i);
        });
    }
}