package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        lista.add(new Estudiante("LU-2024-006", "Martin Carrizo", 9.1, 24, 26));
       
        

        //COMPARABLE
        System.out.println("\n===== Lista antes de Ordenar =====");

        for (Estudiante estudiante : lista) {
            System.out.println("Estudiante: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }

        Collections.sort(lista);

        System.out.println("\n===== Lista Ordenada =====");
        for (Estudiante estudiante : lista) {
            System.out.println("Estudiante: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }


        System.out.println("\t\nEJERCICIO 4: Comparators con lambdas y method references");
        //COMPARATOR

        System.out.println("======= Comparators: Ordenado por Materias aprobadas DESC=========");
        Comparator<Estudiante> materiasAprobadas = (a, b) -> Integer.compare(a.getCantidadMateriasAprobadas(), b.getCantidadMateriasAprobadas());
        lista.sort(materiasAprobadas);
        for (Estudiante estudiante : lista) {
            System.out.println( estudiante.getNombre() + " | Materias aprobadas: " + estudiante.getCantidadMateriasAprobadas());
        }
        
        System.out.println("\n======= Comparators: Ordenado por Nombre ASC=========");
        Comparator<Estudiante> porNombre = Comparator.comparing(Estudiante::getNombre);
        lista.sort(porNombre);
        for (Estudiante estudiante : lista) {
            System.out.println("Nombre: " + estudiante.getNombre());
        }

        System.out.println("\n======= Comparators: Ordenado por Edades ASC=========");
        Comparator<Estudiante> porEdad = Comparator.comparing(Estudiante::getEdad);
        lista.sort(porEdad);
        for (Estudiante estudiante : lista) {
            System.out.println("Nombre: " + estudiante.getNombre() + " | Edad: " + estudiante.getEdad());
        }


        System.out.println("\t\nEJERCICIO 5: Desempate con thenComparing()");
        
        //Ordenado por Promedio DESC y después desempate con Nombre ASC
        Comparator<Estudiante> porPromedioDesc = Comparator.comparing(Estudiante::getPromedio).reversed();
        Comparator<Estudiante> porPromedioYNombre = porPromedioDesc.thenComparing(Estudiante::getNombre);

        lista.sort(porPromedioYNombre);
        System.out.println("========== Por Promedio(Desc) y desempate con Nombre(Asc) =============");
        for (Estudiante estudiante : lista) {
            System.out.println("Nombre: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }

        //Usa el reversed()
        Comparator<Estudiante> porPromedioAsc = porPromedioDesc.reversed();

        lista.sort(porPromedioAsc);
        System.out.println("\n========== Por Promedio(Asc) luego de usar reverserd()=============");
        for (Estudiante estudiante : lista) {
            System.out.println("Nombre: " + estudiante.getNombre() + " | Promedio: " + estudiante.getPromedio());
        }

        //Combinar todo
        Comparator<Estudiante> materiasAprobadasDesc = Comparator.comparingInt(Estudiante::getCantidadMateriasAprobadas).reversed();
        Comparator<Estudiante> materiaDescYNombre = materiasAprobadasDesc.thenComparing(Estudiante::getNombre);

        lista.sort(materiaDescYNombre);
        System.out.println("\n========== Por Materias(Desc) y desempate con Nombre(ASC) =============");
        for (Estudiante estudiante : lista) {
            System.out.println("Nombre: " + estudiante.getNombre() + " | Materias Aprobadas: " + estudiante.getCantidadMateriasAprobadas());
        }

    }
}
