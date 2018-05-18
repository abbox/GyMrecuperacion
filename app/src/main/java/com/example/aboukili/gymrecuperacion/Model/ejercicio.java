package com.example.aboukili.gymrecuperacion.Model;

public class ejercicio {

    private String ejercicio;
    private String series;
    private String repeticiones;
    private String descanso;
    private String dia;


    public ejercicio(){

    }

    public ejercicio(String ejercicio, String series, String repeticiones, String descanso, String dia) {
        this.ejercicio = ejercicio;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descanso = descanso;
        this.dia = dia;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getDescanso() {
        return descanso;
    }

    public void setDescanso(String descanso) {
        this.descanso = descanso;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "ejercicio{" +
                "ejercicio='" + ejercicio + '\'' +
                ", series='" + series + '\'' +
                ", repeticiones='" + repeticiones + '\'' +
                ", descanso='" + descanso + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}
