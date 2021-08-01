package com.ismaias.dogidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserHome extends AppCompatActivity {

    private TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        Log.i("SOLOVINO","Llegamos a la página de incio para un usuario registrado");

        saludo = findViewById(R.id.textSayHello);
        String data = getIntent().getExtras().getString("appDogUser","Chale, no hay nombre");
        saludo.setText("¡Hola "+data+"!");

    }
}