package com.joset.newreci;

public class Usuario {
    private Integer id;
    private String nombre;
    private String telefono;
    private String hora;


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String telefono, String hora) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.hora = hora;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getHora() {
        return hora;
    }






}
