package com.example.mdjb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mdjb.R;

public class FormulaireSaisieActivity extends AppCompatActivity{
    //initialisation de score =0
    private int scoreSommeil = 0, scoreEau = 0, scoreNutrition = 0, scoreActivite = 0, scoreEnergie = 0;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulaire_saisie);

        //initialisation des composants
        editNote = findViewById(R.id.edit_note);
        Button btnSubmit = findViewById(R.id.btn_submit);
        //Section sommeil
        ImageButton btnSleepHappy = findViewById(R.id.btn_sleep_happy);
        ImageButton btnSleepNeutral = findViewById(R.id.btn_sleep_neutral);
        ImageButton btnSleepSad = findViewById(R.id.btn_sleep_sad);
        btnSleepHappy.setOnClickListener(v->{scoreSommeil=3; toast("Sommeil au top :D");});
        btnSleepNeutral.setOnClickListener(v -> { scoreSommeil = 2; toast("Sommeil correct :)"); });
        btnSleepSad.setOnClickListener(v -> { scoreSommeil = 1; toast("Mauvais sommeil :("); });

        //Section eau
        ImageButton btnWaterHappy = findViewById(R.id.btn_water_happy);
        ImageButton btnWaterNeutral = findViewById(R.id.btn_water_neutral);
        ImageButton btnWaterSad = findViewById(R.id.btn_water_sad);

        btnWaterHappy.setOnClickListener(v -> { scoreEau = 3; toast("Bien hydraté :D"); });
        btnWaterNeutral.setOnClickListener(v -> { scoreEau = 2; toast("Hydratation moyenne :)"); });
        btnWaterSad.setOnClickListener(v -> { scoreEau = 1; toast("Pas assez d'eau :("); });

        //section nutrition
        ImageButton btnNutriHappy = findViewById(R.id.btn_nutrition_happy);
        ImageButton btnNutriNeutral = findViewById(R.id.btn_nutrition_neutral);
        ImageButton btnNutriSad = findViewById(R.id.btn_nutrition_sad);

        btnNutriHappy.setOnClickListener(v -> { scoreNutrition = 3; toast("Repas équilibré :D"); });
        btnNutriNeutral.setOnClickListener(v -> { scoreNutrition = 2; toast("Repas correct :)"); });
        btnNutriSad.setOnClickListener(v -> { scoreNutrition = 1; toast("Mal mangé :("); });

        //section activité
        ImageButton btnActHappy = findViewById(R.id.btn_activity_happy);
        ImageButton btnActNeutral = findViewById(R.id.btn_activity_neutral);
        ImageButton btnActSad = findViewById(R.id.btn_activity_sad);

        btnActHappy.setOnClickListener(v -> { scoreActivite = 3; toast("Très actif :D"); });
        btnActNeutral.setOnClickListener(v -> { scoreActivite = 2; toast("Activité modérée :)"); });
        btnActSad.setOnClickListener(v -> { scoreActivite = 1; toast("Sédentaire aujourd'hui :("); });

        //section energie
        ImageButton btnEnergyHappy = findViewById(R.id.btn_energy_happy);
        ImageButton btnEnergyNeutral = findViewById(R.id.btn_energy_neutral);
        ImageButton btnEnergySad = findViewById(R.id.btn_energy_sad);

        btnEnergyHappy.setOnClickListener(v -> { scoreEnergie = 3; toast("Plein d'énergie :D"); });
        btnEnergyNeutral.setOnClickListener(v -> { scoreEnergie = 2; toast("Énergie moyenne :)"); });
        btnEnergySad.setOnClickListener(v -> { scoreEnergie = 1; toast("Très fatigué :("); });

        //bouton enregistrer
        btnSubmit.setOnClickListener(v -> {

            //Calcul de la moyenne
            int moyenne = (scoreSommeil + scoreEau + scoreNutrition + scoreActivite + scoreEnergie) / 5;

            //préparation de la date
            String dateDuJour = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            String note = editNote.getText().toString();

            // sauvegarder en arrière-plan
            new Thread(() -> {
                boolean success = MoodDAO.saveRecord(
                        dateDuJour,
                        String.valueOf(scoreSommeil),
                        String.valueOf(scoreEau),
                        String.valueOf(scoreNutrition),
                        String.valueOf(scoreActivite),
                        String.valueOf(scoreEnergie),
                        note
                );

                runOnUiThread(() -> {
                    if (success) {
                        Intent intent = new Intent(this, SummaryActivity.class);
                        intent.putExtra("FINAL_SCORE", moyenne);
                        intent.putExtra("NOTE", note);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Erreur : Vérifie ta connexion XAMPP", Toast.LENGTH_LONG).show();
                    }
                });
            }).start();
        });
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}