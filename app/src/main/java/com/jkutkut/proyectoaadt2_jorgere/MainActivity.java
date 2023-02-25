package com.jkutkut.proyectoaadt2_jorgere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jkutkut.proyectoaadt2_jorgere.custom.CustomActivity;

public class MainActivity extends CustomActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnStart);

        btnSend.setOnClickListener(v -> {
            Intent i = new Intent(this, QueryActivity.class);
            startActivity(i);
        });
    }
}