package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ImageView imgTea, imgMilk, imgWater, imgMangoJuice;
    Integer itemOpt;
    Button btnCart;
    ArrayList<Item> cart = new ArrayList<>();
    Item order = new Item();

    public void init(){
        // Menu 1 : Drinks
        imgTea = findViewById(R.id.img_menu_tea);
        imgMilk = findViewById(R.id.img_menu_milk);
        imgWater = findViewById(R.id.img_menu_water);
        imgMangoJuice = findViewById(R.id.img_menu_mango);
        btnCart = findViewById(R.id.btn_myorder_home);
        cart = getIntent().getParcelableArrayListExtra("CART");
        Log.d("INIT_MENU_CART_ORDER", String.valueOf(cart.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        // Option Drinks
        // Move to Menu page when clicking Drinks image

        imgTea.setOnClickListener(view -> {
            itemOpt = 1;
            Intent intent = new Intent(getApplication(), OrderActivity.class);
            intent.putExtra("item", itemOpt);
            intent.putParcelableArrayListExtra("CART", cart);
            startActivity(intent);
        }
        );

        imgMilk.setOnClickListener(view -> {
            itemOpt = 2;
            Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
            intent.putExtra("item", itemOpt);
            intent.putParcelableArrayListExtra("CART", cart);
            startActivity(intent);
        }
        );

        imgWater.setOnClickListener(view -> {
            itemOpt = 3;
            Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
            intent.putExtra("item", itemOpt);
            intent.putParcelableArrayListExtra("CART", cart);
            startActivity(intent);
        }
        );

        imgMangoJuice.setOnClickListener(view -> {
            itemOpt = 4;
            Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
            intent.putExtra("item", itemOpt);
            intent.putParcelableArrayListExtra("CART", cart);
            startActivity(intent);
        }
        );

        btnCart.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this, CartActivity.class);
            i.putParcelableArrayListExtra("CART", cart);
            startActivity(i);
        });
    }
}