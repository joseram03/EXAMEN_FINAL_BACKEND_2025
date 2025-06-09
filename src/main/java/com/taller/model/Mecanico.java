package com.taller.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaIngreso;
    private String especialidad;

    @ManyToMany(mappedBy = "mecanicos")
    private List<DetalleServicio> detalles;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<DetalleServicio> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleServicio> detalles) {
        this.detalles = detalles;
    }

    public Mecanico() {
    }
}
