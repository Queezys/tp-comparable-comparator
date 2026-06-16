package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;
import jakarta.annotation.PostConstruct;

@Service
public class EstudianteService {

    private final List<Estudiante> estudiantes = new ArrayList<>();

    //Mapa para guardar las estrategias
    private final Map<String, Comparator<Estudiante>> estrategiasOrdeniamiento = new HashMap<>();

    //Constructor
    public EstudianteService(){
        estrategiasOrdeniamiento.put("promedio", Comparator.comparingDouble(Estudiante::getPromedio));
        estrategiasOrdeniamiento.put("edad", Comparator.comparingInt(Estudiante::getEdad));
        estrategiasOrdeniamiento.put("nombre", Comparator.comparing(Estudiante::getNombre));
        estrategiasOrdeniamiento.put("materiasAprobadas", Comparator.comparingInt(Estudiante::getCantidadMateriasAprobadas));
        estrategiasOrdeniamiento.put("legajo", Comparator.comparing(Estudiante::getLegajo));
    }


    @PostConstruct
    public void EstudianteServices(){
        estudiantes.add(new Estudiante("LU-001", "Martín Quiroga", 8.5, 22, 18));
        estudiantes.add(new Estudiante("LU-002", "Valeria Díaz", 8.5, 20, 15));
        estudiantes.add(new Estudiante("LU-003", "Facundo Castro", 7.2, 24, 22));
        estudiantes.add(new Estudiante("LU-004", "Camila Torres", 9.1, 21, 24));
        estudiantes.add(new Estudiante("LU-005", "Lucas González", 9.1, 23, 24));
        estudiantes.add(new Estudiante("LU-006", "Agustina López", 6.8, 19, 10));
        estudiantes.add(new Estudiante("LU-007", "Nahuel Herrera", 7.5, 22, 14));
        estudiantes.add(new Estudiante("LU-008", "Florencia Ríos", 8.9, 25, 20));
        estudiantes.add(new Estudiante("LU-009", "Tomás Sosa", 6.5, 20, 12));
        estudiantes.add(new Estudiante("LU-010", "Lucía Fernández", 7.8, 21, 16));
    }

    public List<Estudiante> all(){
        return new ArrayList<>(estudiantes);
    }

    public List<Estudiante> ordenar(List<Estudiante> lista, String sortBy, String order){

        Comparator<Estudiante> comparator = estrategiasOrdeniamiento.get(sortBy.toLowerCase());

        if (comparator == null) {
            throw new IllegalArgumentException("El criterio no existe.");
        }

        List<Estudiante> resultado = new ArrayList<>(lista);

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        //Desempate por legajo
        comparator = comparator.thenComparing(Estudiante::getLegajo);

        resultado.sort(comparator);

        return resultado;
    }

    public List<String> getCriteriosAceptados(){
        return new ArrayList<>(estrategiasOrdeniamiento.keySet());
    }
}