package ar.edu.unlar.prog3.tp_comparable_comparator.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Estudiante implements Comparable<Estudiante>{
    
    private String legajo;
    private String nombre;
    private double promedio;
    private int edad;
    private int cantidadMateriasAprobadas;

    public Estudiante(String legajo, String nombre, double promedio, int edad, int cantidadMateriasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.edad = edad;
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
    }

    @Override
    public int compareTo(Estudiante otro) {
        
        return Double.compare(otro.getPromedio(), this.promedio);
    }
    
}
