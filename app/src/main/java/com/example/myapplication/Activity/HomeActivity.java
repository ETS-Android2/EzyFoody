package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button btnTopUp;
    ImageView imgDrinks, imgFoods, imgSnacks;
    Integer menuOpt;
    ArrayList<Item> cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTopUp = findViewById(R.id.btn_cart);

        imgDrinks = findViewById(R.id.img_drinks);
        imgFoods = findViewById(R.id.img_foods);
        imgSnacks = findViewById(R.id.img_snacks);

        //Move to Menu page when clicking Drinks image
        imgDrinks.setOnClickListener(view -> {
                menuOpt = 1;
                Intent intent = new Intent(getApplication(), MenuActivity.class);
                intent.putExtra("menu", menuOpt);
                intent.putParcelableArrayListExtra("CART", cart);
                startActivity(intent);
            }
        );

        //Move to Menu page when clicking Foods image
        imgFoods.setOnClickListener(view -> {
                menuOpt = 2;
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                intent.putExtra("menu", menuOpt);
                intent.putParcelableArrayListExtra("CART", cart);
                startActivity(new Intent(HomeActivity.this, MenuActivity.class));
            }
        );

        //Move to Menu page when clicking Snacks Button
        imgSnacks.setOnClickListener(view -> {
                menuOpt = 3;
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                intent.putExtra("menu", menuOpt);
                intent.putParcelableArrayListExtra("CART", cart);
                startActivity(new Intent(HomeActivity.this, MenuActivity.class));
            }
        );
    }
}