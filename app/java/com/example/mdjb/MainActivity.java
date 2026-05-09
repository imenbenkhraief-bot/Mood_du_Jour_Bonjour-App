package com.example.mdjb;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.mdjb.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //recuperation des boutons par id
        Button btnAdd = findViewById(R.id.btn_add_entry);
        Button btnHistory = findViewById(R.id.btn_history);
        Button btnGuide = findViewById(R.id.btn_guide);
        //gestion de la navigation
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vers formulaire
                Intent intent = new Intent(MainActivity.this, FormulaireSaisieActivity.class);
                startActivity(intent);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vers historique
                Intent intent = new Intent(MainActivity.this, HistoriqueActivity.class);
                startActivity(intent);
            }
        });
        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vers guide
                Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });
    }
}