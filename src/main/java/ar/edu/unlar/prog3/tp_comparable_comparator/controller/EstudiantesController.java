package ar.edu.unlar.prog3.tp_comparable_comparator.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.model.RequestError;
import ar.edu.unlar.prog3.tp_comparable_comparator.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {
    
    EstudianteService estudianteService;

    public EstudiantesController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping
    ResponseEntity<?> mostrarLista(
        @RequestParam (defaultValue = "promedio") String sortBy,
        @RequestParam(defaultValue = "asc") String order){

            try {
                List<Estudiante> base = estudianteService.all();
                List<Estudiante> filtrada = estudianteService.ordenar(base, sortBy, order);
                return ResponseEntity.ok(filtrada);
            } catch (IllegalArgumentException e) {
                
                RequestError errorBody = new RequestError("Criterio de ordenamiento no válido", 
                sortBy, estudianteService.getCriteriosAceptados());

                return ResponseEntity.badRequest().body(errorBody);
            }
    }

}
