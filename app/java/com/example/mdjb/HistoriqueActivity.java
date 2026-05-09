package com.example.mdjb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historique);

        Button btnBack = findViewById(R.id.btn_back_home);
        ListView maListe = findViewById(R.id.list_historique);

        new Thread(() -> {
            List<String[]> deVraiesDonnees = MoodDAO.getAllRecords();

            //le thread principal
            runOnUiThread(() -> {
                if (deVraiesDonnees.isEmpty()) {
                    Toast.makeText(this, "Aucun historique trouvé", Toast.LENGTH_SHORT).show();
                }

                HistoryAdapter adapter = new HistoryAdapter(this, deVraiesDonnees);
                maListe.setAdapter(adapter);
            });
        }).start();

        //bouton de retour
        btnBack.setOnClickListener(v -> finish());
    }
}