package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Adapter.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ArrayList<Item> cart = new ArrayList<>();
    RecyclerView recyclerView;
    Button btnPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btnPayNow = findViewById(R.id.btn_pay_now);

        cart = getIntent().getParcelableArrayListExtra("CART");

        if(cart != null){
            Log.d("CART_ITEM_ORDER", String.valueOf(cart.size()));
            if (cart.size() == 0){
                Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
            }
            else{
                recyclerView = findViewById(R.id.recyclerView);
                MyAdapter adp = new MyAdapter(this, cart);
                recyclerView.setAdapter(adp);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }
        else{
            Toast.makeText(this, "You haven't order anything", Toast.LENGTH_SHORT).show();
        }

        btnPayNow.setOnClickListener(view -> {
            Intent i = new Intent(getApplication(), OrderCompleteActivity.class);
            i.putParcelableArrayListExtra("CART", cart);
            startActivity(i);
        });
    }
}