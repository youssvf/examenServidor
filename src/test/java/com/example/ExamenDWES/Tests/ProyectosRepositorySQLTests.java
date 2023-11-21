package com.example.ExamenDWES.Tests;

import com.example.ExamenDWES.Proyecto.application.ProyectosUseCases;
import com.example.ExamenDWES.Proyecto.domain.Proyecto;
import com.example.ExamenDWES.Proyecto.infrastructure.ProyectosRepositorySQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProyectosRepositorySQLTests {
    private ProyectosUseCases proyectosUseCases;
    public ProyectosRepositorySQLTests(){
        this.proyectosUseCases = new ProyectosUseCases(new ProyectosRepositorySQL());
    }

    @Test
    void getAll(){
        List<Proyecto> proyectos = proyectosUseCases.getAll();
        assertEquals(3,proyectos.size());
    }
    @Test
    void getProyecto(){
        String proyectobuscado = "Sitio web con Spring Boot y React";
        Integer idbuscado = null;
        List<Proyecto> proyectos = proyectosUseCases.getAll();
        for (Proyecto p: proyectos){
            if (p.getNombre().equals(proyectobuscado)){
                idbuscado = p.getId();
            }
        }
        Proyecto proyecto = this.proyectosUseCases.getProyecto(idbuscado);
        assertEquals(idbuscado,proyecto.getId());
    }
    @Test
    void borrar(){
        Integer id = null;
        Proyecto proyecto = this.proyectosUseCases.save("proyecto a borrar");
        List<Proyecto> proyectos = this.proyectosUseCases.getAll();
        for (Proyecto p : proyectos){
            if (p.getNombre().equals(proyecto.getNombre())){
                id = p.getId();
            }
        }
        Proyecto proyectoborrado = this.proyectosUseCases.delete(id);
        assertEquals(proyectoborrado.getNombre(),proyecto.getNombre());

    }

    @Test
    void save(){
        Integer id = null;
        Proyecto proyectoguardado = this.proyectosUseCases.save("Proyecto de prueba");
        List<Proyecto> proyectos = this.proyectosUseCases.getAll();
        for (Proyecto p: proyectos){
            if (p.getNombre().equals(proyectoguardado.getNombre())){
                assertEquals(p.getNombre(),proyectoguardado.getNombre());
                id = p.getId();
            }
        }
        Proyecto borrar = this.proyectosUseCases.delete(id);
    }
}
