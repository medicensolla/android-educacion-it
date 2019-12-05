package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapp.Models.Usuario;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registrarse;
    private EditText nombre,correo,contraseña,apellido;
    private Usuario u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registrarse = findViewById(R.id.BtnRegistrarse);
        nombre = findViewById(R.id.etNombreUsuario);
        correo = findViewById(R.id.editTextCorreo);
        contraseña = findViewById(R.id.editTextContrasenia);
        apellido = findViewById(R.id.etApellidoUsuario);

        registrarse.setOnClickListener(this);

      //  u1 = new Usuario(nombre,correo,contraseña,apellido);



    }




    @Override
    public void onClick(View v) {

        if(v == registrarse){

            if(!this.nombre.getText().toString().isEmpty() && (!this.apellido.getText().toString().isEmpty())) {

                this.registerUser(this.nombre.getText().toString(), this.correo.getText().toString(),
                        this.contraseña.getText().toString(), this.apellido.getText().toString());

            } else {

                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show();

            }

        }

    }


    public void registerUser(String nombre, String correo, String contrasenia, String apellido) {

        Intent intent = new Intent(RegisterActivity.this,PerfilUsuarioActivity.class);
        intent.putExtra("nombreUsuario", nombre);
        intent.putExtra("correoUsuario",correo);
        intent.putExtra("contraseniaUsuario",contrasenia);
        intent.putExtra("apellidoUsuario",apellido);

        intent.putExtra("Usuario1",u1);


        startActivity(intent);
        finish();
    }
}
