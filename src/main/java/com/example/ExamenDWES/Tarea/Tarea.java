package com.example.ExamenDWES.Tarea;

import com.example.ExamenDWES.Especialidad.Especialidad;
import com.example.ExamenDWES.Especialista.Especialista;

import java.util.List;

public class Tarea {
    private String codigo, nombre;
    private Especialidad especialidad;

    private Integer proyecto;
    private Especialista especialista;


    public Tarea(String codigo, String nombre, Integer proyecto, String especialidad, Integer especialista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.proyecto = proyecto;
        this.especialidad = null;
        this.especialista = null;

    }


    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getProyecto() {
        return proyecto;
    }


}
