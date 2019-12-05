package com.example.firstapp.Models;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellido;
    private String correo;

    private String ciudad;
    private String Pais;
    private  int edad;



    public Usuario (){
        super();
    }

    public Usuario(String nombre, String apellido, String ciudad, String pais, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.Pais = pais;
        this.edad = edad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
