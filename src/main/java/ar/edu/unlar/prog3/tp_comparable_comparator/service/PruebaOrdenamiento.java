package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;

public class PruebaOrdenamiento {
    
    public static void main(String[] args){

        List<Estudiante> lista = new ArrayList<>();
        
        lista.add(new Estudiante("LU-2024-001", "Martín Quiroga", 8.5, 22, 18));
        lista.add(new Estudiante("LU-2024-002", "Valeria Díaz", 8.5, 20, 15));
        lista.add(new Estudiante("LU-2024-003", "Facundo Castro", 7.2, 24, 22));
        lista.add(new Estudiante("LU-2024-004", "Camila Torres", 9.1, 21, 24));
        lista.add(new Estudiante("LU-2024-005", "Lucas González", 9.1, 23, 24));

        System.out.println("\n===== Lista antes de Ordenar =====");

        for (Estudiante estudiante : lista) {
            System.out.println("Estudiante: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }

        Collections.sort(lista);

        System.out.println("\n===== Lista Ordenada =====");
        for (Estudiante estudiante : lista) {
            System.out.println("Estudiante: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }

    }
}
