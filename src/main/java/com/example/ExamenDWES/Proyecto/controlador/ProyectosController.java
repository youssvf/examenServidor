package com.example.ExamenDWES.Proyecto.controlador;

import com.example.ExamenDWES.Proyecto.application.ProyectosUseCases;
import com.example.ExamenDWES.Proyecto.domain.Proyecto;
import com.example.ExamenDWES.Proyecto.infrastructure.ProyectosRepositorySQL;
import com.example.ExamenDWES.Tarea.Tarea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ProyectosController {
    private ProyectosUseCases proyectosUseCases;
    public ProyectosController(){
        this.proyectosUseCases = new ProyectosUseCases(new ProyectosRepositorySQL());
    }

    @GetMapping("/proyectos")
    public String getAll(Model model){
        List<Proyecto> proyectos = proyectosUseCases.getAll();
        model.addAttribute("proyectos",proyectos);
        return "proyectos";
    }

    @GetMapping("/proyecto/{id}")
    public String getProyecto(@PathVariable Integer id, Model model){
        Proyecto proyecto = proyectosUseCases.getProyecto(id);
        model.addAttribute("proyecto",proyecto);
        for (Tarea t: proyecto.getTareas()){
            System.out.println(t);
        }
        return "proyecto";
    }
    @PostMapping("/proyecto/borrar")
    public String delete(Model model,@RequestParam Integer id){
        Proyecto proyecto = this.proyectosUseCases.delete(id);
        return "redirect:/proyectos";
    }

    @GetMapping("/proyecto/nuevo")
    public String nuevo(){
        return "nuevo";
    }

    @PostMapping("/proyecto/save")
    public String save(@RequestParam String nombre){
        Proyecto proyecto = this.proyectosUseCases.save(nombre);
        return "redirect:/proyectos";
    }

}
