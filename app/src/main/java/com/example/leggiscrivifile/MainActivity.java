package com.example.leggiscrivifile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtNomeFile;
    Button btnLeggi, btnScrivi;
    Gestore gest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String righeLette = gest.leggiFile("prova.txt", getApplicationContext());
            }
        });
        
        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito = gest.scriviFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show();
            }
        });
    }
}