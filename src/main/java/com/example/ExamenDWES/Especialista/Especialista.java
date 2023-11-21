package com.example.ExamenDWES.Especialista;

public class Especialista {
    private Integer id;
    private String nombre, especialida;

    public Especialista(Integer id, String nombre, String especialida) {
        this.id = id;
        this.nombre = nombre;
        this.especialida = especialida;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialida() {
        return especialida;
    }
}
