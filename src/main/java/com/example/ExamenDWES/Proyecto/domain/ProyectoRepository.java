package com.example.ExamenDWES.Proyecto.domain;

import java.util.List;

public interface ProyectoRepository {
    public List<Proyecto> getAll();
    public Proyecto getProyecto(Integer id);
    public Proyecto delete(Integer id);
    public Proyecto nuevo();
    public Proyecto save(String nombre);

    public Proyecto getProyectoCompleto(Integer id);
}
