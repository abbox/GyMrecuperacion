package com.example.aboukili.gymrecuperacion.Model;

import java.util.List;

public class rutina {

    private String dia;
    private String musculo;

    public rutina(){
        
    }

    public rutina(String dia, String musculo) {
        this.dia = dia;
        this.musculo = musculo;

    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }


    @Override
    public String toString() {
        return "rutina{" +
                "dia='" + dia + '\'' +
                ", musculo='" + musculo + '\'' +
                '}';
    }
}
