package com.ismaias.dogidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class DogRegister extends AppCompatActivity {

    ImageView dogPic;
    ImageButton save;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_register);


        dogPic = findViewById(R.id.picDog);

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
        dogPic.setImageBitmap(bitmap);

    }


    public void registroUsuario(View v) {
        Toast.makeText(this, "Esta función aún no está disponible en este momento", Toast.LENGTH_LONG).show();
    }
    public void backHome(View view) {
        Intent intent = new Intent(this, UserHome.class);
        startActivity(intent);
    }
}