package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    Button btnOrderDrinks, btnOrderFoods, btnOrderSnacks, btnTopUp;
    ImageView imgDrinks, imgFoods, imgSnacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnOrderDrinks = findViewById(R.id.btn_order_1);
        btnOrderFoods = findViewById(R.id.btn_order_2);
        btnOrderSnacks = findViewById(R.id.btn_order_3);
        btnTopUp = findViewById(R.id.btn_top_up);

        imgDrinks = findViewById(R.id.img_drinks);
        imgFoods = findViewById(R.id.img_foods);
        imgSnacks = findViewById(R.id.img_snacks);

        //Move to Menu page when clicking Order Button
        btnOrderDrinks.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(new Intent(HomeActivity.this, MenuActivity.class));
              }
          }
        );

        //Move to Menu page when clicking Order Button
        btnOrderFoods.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(new Intent(HomeActivity.this, MenuActivity.class));
              }
          }
        );

        //Move to Menu page when clicking Order Button
        btnOrderSnacks.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(new Intent(HomeActivity.this, MenuActivity.class));
              }
          }
        );
    }
}