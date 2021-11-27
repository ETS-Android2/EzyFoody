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

import com.example.myapplication.R;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {
    ArrayList<Item> cart = new ArrayList<>();
    RecyclerView recyclerView;
    Integer totalPrice = 0;
    Button btnMainMenu;
    TextView tvFinalTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        tvFinalTotalPrice = findViewById(R.id.tvFinalTotalPrice);

        cart = getIntent().getParcelableArrayListExtra("CART");
        Log.d("FINAL_ORDER", String.valueOf(cart.size()));

        if(cart != null){
            Log.d("CART_ITEM_ORDER", String.valueOf(cart.size()));
            if (cart.size() == 0){
                Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
                tvFinalTotalPrice.setText("Total : Rp. " + totalPrice.toString());
            }
            else{
                recyclerView = findViewById(R.id.recyclerViewComplete);
                com.example.myapplication.adapter.CheckoutActivity adp = new com.example.myapplication.adapter.CheckoutActivity(this, cart);
                recyclerView.setAdapter(adp);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                // Calculate Total
                for (Item item:cart) {
                    int price = item.getItemQty() * item.getItemPrice();
                    totalPrice += price;
                }
                tvFinalTotalPrice.setText("Total : Rp. " + totalPrice.toString());
            }
        }
        else{
            Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
        }

        btnMainMenu.setOnClickListener(view -> {
            Intent i = new Intent(getApplication(), HomeActivity.class);
            i.putParcelableArrayListExtra("CART", cart);
            i.putExtra("TOTAL_PRICE", totalPrice);
            startActivity(i);
        });
    }
}