package com.jkutkut.proyectoaadt2_jorgere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {

    private Button btnFilterQuery;
    private Button btnQuery;
    private RecyclerView rvQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        btnFilterQuery = findViewById(R.id.btnFilterQuery);
        btnQuery = findViewById(R.id.btnQuery);
        rvQuery = findViewById(R.id.rvQuery);

        btnQuery.setOnClickListener(v -> {
            // TODO
            Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show();
        });
        btnFilterQuery.setOnClickListener(v -> {
            // TODO
            Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show();
        });
    }
}