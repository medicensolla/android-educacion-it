package com.example.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String PREFS_NAME = "PREFS_NAME";

    private static final String KEY_USER_EMAIL = "KEY_USER_EMAIL";

    private static final String KEY_USER_PASSWORD = "KEY_USER_PASSWORD";

    private EditText e1Correo, e1Contrasenia;
    private Button logIn, registrarse;
    private CheckBox remember;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1Correo = findViewById(R.id.editTextCorreo);
        e1Contrasenia = findViewById(R.id.editTextContrasenia);
        logIn = findViewById(R.id.BtnIniciarSesion);
        registrarse = findViewById(R.id.BtnRegistrarse);
        remember = findViewById(R.id.check_remember);

        prefs = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String email = prefs.getString(KEY_USER_EMAIL,"");
        String contrasenia = prefs.getString(KEY_USER_PASSWORD,"");

        if(!email.isEmpty() && !contrasenia.isEmpty()){

            e1Correo.setText(email);
            e1Contrasenia.setText(contrasenia);
            remember.setChecked(true);

        }


        logIn.setOnClickListener(this);
        registrarse.setOnClickListener(this);


    }

    public Boolean validarEmail() {


        if (!Patterns.EMAIL_ADDRESS.matcher(this.e1Correo.getText().toString()).matches()) {

            Toast.makeText(this, "Not Valid Email", Toast.LENGTH_SHORT).show();

            return false;

        }

        if (e1Correo.getText().toString().isEmpty()) {


            return false;
        }

        return true;

    }


    public Boolean validarContrasenia() {

        if (!this.e1Contrasenia.getText().toString().isEmpty()) {

            if (this.e1Contrasenia.getText().toString().length() < 7) {

                Toast.makeText(this, "Not valid Password Format", Toast.LENGTH_SHORT).show();

                return false;

            }


        }

        if (this.e1Contrasenia.getText().toString().isEmpty()) {

            Toast.makeText(this, "Empty Password", Toast.LENGTH_SHORT).show();

            return false;
        }


        return true;


    }


    @Override
    public void onClick(View v) {

        if (v == logIn) {

            String correo = e1Correo.getText().toString();
            String contrasenia = e1Contrasenia.getText().toString();
            boolean recordarUsuario = this.remember.isChecked();

            if (this.validarEmail() && this.validarContrasenia()) {

                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                this.logInUser(this.e1Correo.getText().toString(), this.e1Contrasenia.getText().toString());

            }

            if(recordarUsuario){

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString(KEY_USER_EMAIL,correo);
                editor.putString(KEY_USER_PASSWORD,contrasenia);
                editor.commit();
            }


        }

        if (v == registrarse) {

            this.registerUser();


        }
    }


    public void logInUser(String correo, String contrasenia) {

        Intent intent = new Intent(MainActivity.this, TareasActivity.class);
        intent.putExtra("correo_usuario", correo);
        intent.putExtra("contrasenia", contrasenia);

        startActivity(intent);


    }

    public void registerUser() {

        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);

        startActivity(intent);
    }
}
