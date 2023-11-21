package com.example.ExamenDWES.Proyecto.infrastructure;

import com.example.ExamenDWES.Proyecto.domain.Proyecto;
import com.example.ExamenDWES.Proyecto.domain.ProyectoRepository;
import com.example.ExamenDWES.Tarea.Tarea;
import com.example.ExamenDWES.context.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProyectosRepositorySQL implements ProyectoRepository {

    @Override
    public List<Proyecto> getAll() {
        List<Proyecto> proyectos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from proyectos");
            while (rs.next()){
                proyectos.add(new Proyecto(rs.getInt("id"),rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return proyectos;
    }

    @Override
    public Proyecto getProyecto(Integer id) {
        Proyecto proyecto = null;
        List<Tarea> tareas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement("select proyectos.*, tareas.* from proyectos " +
                    "left join tareas on tareas.proyecto = proyectos.id " +
                    "where proyectos.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                proyecto = new Proyecto(rs.getInt("id"),rs.getString("nombre"));
                tareas.add(new Tarea(rs.getString("codigo"), rs.getString("nombre"),rs.getInt("proyecto"), rs.getString("especialidad"), rs.getInt("especialista")));
            }
            proyecto.setTareas(tareas);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return proyecto;
    }

    @Override
    public Proyecto delete(Integer id) {
        Proyecto proyecto = getProyecto(id);

        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement("delete from tareas where proyecto = ?;");
            PreparedStatement preparedStatement2 = DBConnection.getInstance().prepareStatement("delete from proyectos where id = ?");

            preparedStatement.setInt(1,id);
            preparedStatement2.setInt(1,id);
            preparedStatement.execute();
            preparedStatement2.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return proyecto;
    }

    @Override
    public Proyecto nuevo() {
        return null;
    }

    @Override
    public Proyecto save(String nombre) {
        Proyecto proyecto = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement("insert into proyectos (nombre) values(?)");
            preparedStatement.setString(1,nombre);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        List<Proyecto> proyectos = getAll();
        for (Proyecto p : proyectos){
            if (p.getNombre().equals(nombre));
            proyecto = new Proyecto(p.getId() ,p.getNombre());
        }
        return proyecto;
    }

    @Override
    public Proyecto getProyectoCompleto(Integer id) {
        return null;
    }
}
