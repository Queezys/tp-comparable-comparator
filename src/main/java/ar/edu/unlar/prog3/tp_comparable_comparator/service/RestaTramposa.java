package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;

public class RestaTramposa {
    

    public static void main(String[] args){

        List<Estudiante> lista = new ArrayList<>();

        Estudiante estMax = new Estudiante("LU-2024-0010", "Estudiante maximo", 6.1, Integer.MAX_VALUE, 26);
        Estudiante estNegativo = new Estudiante("LU-2024-0011", "Estudiante negativo", 6.1, -1, 21);
        lista.add(estNegativo);
        lista.add(estMax);

        lista.add(new Estudiante("LU-2024-001", "Martín Quiroga", 8.5, 22, 18));
        lista.add(new Estudiante("LU-2024-002", "Valeria Díaz", 8.5, 20, 15));
        lista.add(new Estudiante("LU-2024-003", "Facundo Castro", 7.2, 24, 22));
        lista.add(new Estudiante("LU-2024-004", "Camila Torres", 9.1, 21, 24));
        lista.add(new Estudiante("LU-2024-005", "Lucas González", 9.1, 23, 24));
        lista.add(new Estudiante("LU-2024-006", "Martin Carrizo", 9.1, 24, 26));
        

        //EJERCICIO 6: RESTA TRAMPOSA
        Comparator<Estudiante> restaTramposa = (e1, e2) -> e1.getEdad() - e2.getEdad();

        int resultadoResta = restaTramposa.compare(estMax, estNegativo);
        System.out.println("\nResultado de Resta Tramposa: " + resultadoResta);

        lista.sort(restaTramposa);
        System.out.println("\n========== Resta Tramposa =============");
        for (Estudiante estudiante : lista) {
                System.out.println("Nombre: " + estudiante.getNombre() + " - Edad: " + estudiante.getEdad());
        }


        //Ahora se arregla como compare
        Comparator<Estudiante> conCompare = (e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad());

        int resultadoCorrecto = conCompare.compare(estMax, estNegativo);
        System.out.println("\nResultado con compare (forma correcta): " + resultadoCorrecto);

        lista.sort(conCompare);
        System.out.println("\n========== Integer.compare() =============");
        for (Estudiante estudiante : lista) {
                System.out.println("Nombre: " + estudiante.getNombre() + " - Edad: " + estudiante.getEdad());
        }
        
    }
}
