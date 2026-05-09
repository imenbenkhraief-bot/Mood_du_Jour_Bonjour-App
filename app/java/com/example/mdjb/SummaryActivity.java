package com.example.mdjb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mdjb.R;

public class SummaryActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);

        ImageView imgFinal = findViewById(R.id.img_final_mood);
        TextView txtMessage = findViewById(R.id.txt_message);
        Button btnHome = findViewById(R.id.btn_back_home);
        int finalScore = getIntent().getIntExtra("FINAL_SCORE", 2);

        //recuperation de la note
        String maNote = getIntent().getStringExtra("NOTE");

        //affichage
        if (finalScore == 3) {
            imgFinal.setImageResource(R.drawable.happy);
            txtMessage.setText("Quelle Journée magnifique ! \nNote : " + maNote);
        } else if (finalScore == 1) {
            imgFinal.setImageResource(R.drawable.sad);
            txtMessage.setText("Journée difficile... Demain sera meilleur. \nNote : " + maNote);
        } else {
            imgFinal.setImageResource(R.drawable.neutral);
            txtMessage.setText("Une journée calme et stable. \nNote : " + maNote);
        }

        //bouton de retour
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retour au dashboard
                Intent intent = new Intent(SummaryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}