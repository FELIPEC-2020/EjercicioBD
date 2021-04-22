package com.ch.ejerciciobd;

public class Ciudad {
    int id;
    String nombre;
    double latitud;
    double longitud;
    int poblacion;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, double latitud, double longitud, int poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Id: " + id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Latitud: " + latitud +" - "+
                "Longitud: " + longitud +'\n' +
                "Poblacion: " + poblacion;
    }
}
