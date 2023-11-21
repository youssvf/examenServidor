package com.example.ExamenDWES.Proyecto.application;

import com.example.ExamenDWES.Proyecto.domain.Proyecto;
import com.example.ExamenDWES.Proyecto.domain.ProyectoRepository;

import java.util.List;

public class ProyectosUseCases {
    private ProyectoRepository proyectoRepository;
    public ProyectosUseCases(ProyectoRepository proyectoRepository){
        this.proyectoRepository = proyectoRepository;
    }
    public List<Proyecto> getAll(){
        return this.proyectoRepository.getAll();
    }
    public Proyecto getProyecto(Integer id){
        return  this.proyectoRepository.getProyecto(id);
    }
    public Proyecto getProyectoCompleto(Integer id){
        return  this.proyectoRepository.getProyectoCompleto(id);
    }
    public Proyecto delete(Integer id){
        return this.proyectoRepository.delete(id);
    }
    public Proyecto nuevo(){
        return this.proyectoRepository.nuevo();
    }
    public Proyecto save(String nombre){
        return this.proyectoRepository.save(nombre);
    }


}
