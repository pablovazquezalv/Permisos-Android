package com.example.recyclew_permisos;

public class Permisos {

    private String Btn;
    private String Permisos;


    public Permisos(String Btn,String Permisos)
    {
        this.Btn=Btn;
        this.Permisos=Permisos;
    }

    public String getBtn() {
        return Btn;
    }

    public void setBtn(String btn) {
        Btn = btn;
    }

    public String getPermisos() {
        return Permisos;
    }

    public void setPermisos(String permisos) {
        Permisos = permisos;
    }
}
