package com.ismaias.dogidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class UserHome extends AppCompatActivity {

    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        Log.i("SOLOVINO","Llegamos a la página de incio para un usuario registrado");

        saludo = findViewById(R.id.textSayHello);
        String data = getIntent().getExtras().getString("appDogUser","Desconocido");
        saludo.setText("¡Hola "+data+"!");

        final ImageButton takePicButton = (ImageButton) findViewById(R.id.imageButton);
        takePicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

    }



    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode== RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            Log.d("SOLOVINO", "Conseguimos la foto");
            //foto.setImageBitmap(imgBitmap);



            Intent intent = new Intent(this, DogRegister.class);
            intent.putExtra("BitmapImage", imgBitmap);
            startActivity(intent);


        }
    }
}