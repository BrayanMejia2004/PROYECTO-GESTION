package com.example.proyectogestion.entidades;

public class Matricula {

    int codigoAsig;
    int documento;
    int grupo;
    String jornada;
    String programaAcademica;

    public Matricula() {

    }

    public int getCodigoAsig() {
        return codigoAsig;
    }

    public void setCodigoAsig(int codigoAsig) {
        this.codigoAsig = codigoAsig;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getProgramaAcademica() {
        return programaAcademica;
    }

    public void setProgramaAcademica(String programaAcademica) {
        this.programaAcademica = programaAcademica;
    }

    @Override
    public String toString() {
        return String.valueOf(codigoAsig);
    }
}
