package com.example.ExamenDWES.Especialidad;

import com.example.ExamenDWES.Especialista.Especialista;

import java.util.ArrayList;
import java.util.List;

public class Especialidad {
    private String codigo, nombre;
    private List<Especialista> especialistas;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialistas = new ArrayList<>();
    }

    public List<Especialista> getEspecialistas() {
        return especialistas;
    }

    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
