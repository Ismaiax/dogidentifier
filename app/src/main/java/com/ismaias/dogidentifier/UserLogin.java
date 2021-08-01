package com.ismaias.dogidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserLogin extends AppCompatActivity {

    EditText inpName;
    EditText inpMail;

    String userName;
    String userMail;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        inpName = findViewById(R.id.inputNameLogin);
        inpMail = findViewById(R.id.inputEmailLogin);


        RequestQueue queue = Volley.newRequestQueue(this);


        // Acción del botón para iniciar sesión
        final ImageButton btnLogin = (ImageButton) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = inpName.getText().toString();
                userMail = inpMail.getText().toString();

                if(userName.length()>1 && userMail.length()>5) {

                    Log.i("SOLOVINO", "Usuario: "+userName+" / Correo: "+userMail);

                    String url ="https://www.ismaias.com/maestria/semestre-3/iot/api/login";
                    StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response)
                                {
                                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                                    try {

                                        JSONObject obj = new JSONObject(response);

                                        if(obj.getInt("code") == 1) {
                                            Log.d("SOLOVINO", obj.getString("token"));

                                            Intent intent = new Intent(UserLogin.this, UserHome.class);
                                            intent.putExtra("appDogUser", obj.getString("user"));
                                            startActivity(intent);

                                        } else {
                                            Log.d("SOLOVINO", "¡Ocurrió un error en el servicio!");
                                        }

                                    } catch (Throwable t) {
                                        Log.e("SOLOVINO", "Error JSON: \"" + response + "\"");
                                    }

                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error)
                                {
                                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                }
                            })
                    {
                        @Override
                        protected Map<String, String> getParams()
                        {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("user", userName);
                            params.put("email", userMail);
                            return params;
                        }
                    };

                    queue.add(strRequest);

                } else {
                    Toast.makeText(getApplicationContext(), "Revisa tu usuario o contraseña. Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}