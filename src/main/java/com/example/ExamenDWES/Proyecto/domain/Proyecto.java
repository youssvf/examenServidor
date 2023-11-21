package com.example.ExamenDWES.Proyecto.domain;

import com.example.ExamenDWES.Tarea.Tarea;


import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private Integer id;
    private String nombre;

    private List<Tarea> tareas;

    public Proyecto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }
    public Proyecto(String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
