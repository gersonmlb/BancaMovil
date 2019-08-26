package itsight.bancamovil.io.model;

import com.google.gson.annotations.SerializedName;

public class Cliente {

    @SerializedName("Id")
    public int Id;

    @SerializedName("Nombre")
    public String Nombre;

    @SerializedName("Telefono")
    public String Telefono;

    @SerializedName("Mail")
    public String Mail;

    @SerializedName("UrlImagen")
    public String UrlImagen;

    public Cliente(int Numero) {
        Id = Numero;
        Nombre = "Nombre " + Numero;
        Telefono = "Telefono " + Numero;
        Mail = "Mail " + Numero;
    }

    @Override
    public String toString() {
        return this.Nombre + " - " + this.Telefono;
    }

//    public Cliente(int id, String nombre, String telefono, String mail) {
//        Id = id;
//        Nombre = nombre;
//        Telefono = telefono;
//        Mail = mail;
//    }
//
//    @Override
//    public String toString() {
//        return this.Nombre + " - " + this.Telefono;
//    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getUrlImagen() {

        return UrlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.UrlImagen = urlImagen;
    }

}
