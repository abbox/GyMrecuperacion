package com.example.aboukili.gymrecuperacion.Model;

public class Usuarios {

    private String nombreUsuario;
    private String apellidosUsuario;
    private String edadUsuario;
    private String pesoUsuario;
    private String CorreoUsuario;

    public Usuarios(){

    }

    public Usuarios(String nombreUsuario, String apellidosUsuario, String edadUsuario, String pesoUsuario, String correoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.edadUsuario = edadUsuario;
        this.pesoUsuario = pesoUsuario;
        this.CorreoUsuario = correoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(String edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getPesoUsuario() {
        return pesoUsuario;
    }

    public void setPesoUsuario(String pesoUsuario) {
        this.pesoUsuario = pesoUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.CorreoUsuario = correoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidosUsuario='" + apellidosUsuario + '\'' +
                ", edadUsuario='" + edadUsuario + '\'' +
                ", pesoUsuario='" + pesoUsuario + '\'' +
                ", CorreoUsuario='" + CorreoUsuario + '\'' +
                '}';
    }
}
