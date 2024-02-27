package com.example.proyectogestion.entidades;

public class Asignatura {

    int codigoAsig;
    String nombreAsig;
    int CredioAsig;

    public Asignatura() {

    }

    public Asignatura(int codigoAsig, String nombreAsig, int credioAsig) {
        this.codigoAsig = codigoAsig;
        this.nombreAsig = nombreAsig;
        this.CredioAsig = credioAsig;
    }

    public int getCodigoAsig() {
        return codigoAsig;
    }

    public void setCodigoAsig(int codigoAsig) {
        this.codigoAsig = codigoAsig;
    }

    public String getNombreAsig() {
        return nombreAsig;
    }

    public void setNombreAsig(String nombreAsig) {
        this.nombreAsig = nombreAsig;
    }

    public int getCredioAsig() {
        return CredioAsig;
    }

    public void setCredioAsig(int credioAsig) {
        CredioAsig = credioAsig;
    }
}
