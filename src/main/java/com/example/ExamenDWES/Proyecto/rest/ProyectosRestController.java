package com.example.ExamenDWES.Proyecto.rest;

import com.example.ExamenDWES.Especialidad.Especialidad;
import com.example.ExamenDWES.Especialista.Especialista;
import com.example.ExamenDWES.Proyecto.application.ProyectosUseCases;
import com.example.ExamenDWES.Proyecto.domain.Proyecto;
import com.example.ExamenDWES.Proyecto.infrastructure.ProyectosRepositorySQL;
import com.example.ExamenDWES.Tarea.Tarea;
import com.example.ExamenDWES.context.DBConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
public class ProyectosRestController {
    private ProyectosUseCases proyectosUseCases;
    public ProyectosRestController(){
        this.proyectosUseCases = new ProyectosUseCases(new ProyectosRepositorySQL());
    }

    @GetMapping("/api/proyectos")
    public List<Proyecto> getAll(){
        return  this.proyectosUseCases.getAll();
    }

    @GetMapping("/api/proyecto/{id}")
    public Proyecto getProyecto(@PathVariable Integer id){
        Proyecto proyecto = this.proyectosUseCases.getProyecto(id);
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement("select * from especialistas " +
                    "left join tareas on tareas.especialista = especialistas.id " +
                    "where tareas.proyecto = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                for (Tarea t: proyecto.getTareas()){
                    t.setEspecialista(new Especialista(rs.getInt("id"),rs.getString("nombre"),rs.getString("especialidad")));
                }
            }

            PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement("select * from especialidades " +
                    "left join tareas on tareas.especialidad = especialidades.codigo " +
                    "where tareas.proyecto = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                for (Tarea e : proyecto.getTareas()){
                    e.setEspecialidad(new Especialidad(resultSet.getString("codigo"),resultSet.getString("nombre")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return  proyecto;
    }
}
