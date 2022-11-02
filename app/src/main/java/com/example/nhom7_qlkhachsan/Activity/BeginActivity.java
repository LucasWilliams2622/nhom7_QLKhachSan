package com.example.nhom7_qlkhachsan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nhom7_qlkhachsan.R;

public class BeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        ImageView ivLogo = findViewById(R.id.ivLogo);
        Glide.with(this).load(R.drawable.logo).into(ivLogo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(BeginActivity.this, LoginActivity.class);
                startActivity(i);
            }
        },2500);
    }
}