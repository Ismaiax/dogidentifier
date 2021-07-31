package com.ismaias.dogidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void registroUsuario(View v) {
        Toast.makeText(this, "Esta función aún no está disponible en este momento", Toast.LENGTH_LONG).show();
    }


    public void sendToLogin(View view) {
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
    }

}