package com.isaaristi.enjoyeating.modelos;

public class Estuve {


    String idUs, imagen, nombre, placeid;

    public Estuve(String idUs, String imagen, String nombre, String placeid) {
        this.idUs = idUs;
        this.imagen = imagen;
        this.nombre = nombre;
        this.placeid = placeid;
    }

    public String getIdUs() {
        return idUs;
    }

    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }
}
