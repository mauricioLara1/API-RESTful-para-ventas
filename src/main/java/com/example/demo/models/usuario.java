package com.example.demo.models;
//model
//las entidades de la clase model son la represe ntacion de una tabla en la base de datos
//aqui se trasforma el sql(js) a codigo de java
//es el primero porque bajo este modelo trabajan todo lo que sea con esta tabl

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta clase representa la tabla "usuarios" en la base de datos
@Entity
@Table(name = "usuarios")
public class usuario {

    // Clave primaria autogenerada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Columnas de la tabla
    private String nombre;
    private String correo;
    private int edad;

    // Campo de estado para soft delete (true = activo, false = eliminado)
    private Boolean estado;

    // Constructor vacío obligatorio
    public usuario() {}

    // Constructor sin ID ni estado (se puede agregar uno completo si lo necesitas)
    public usuario(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.estado = true; // por defecto activo
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getedad() {
        return edad;
    }

    public Boolean getEstado() {
        return estado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setedad(int edad) {
        this.edad = edad;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
