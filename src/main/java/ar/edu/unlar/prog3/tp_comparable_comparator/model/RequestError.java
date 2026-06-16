package ar.edu.unlar.prog3.tp_comparable_comparator.model;

import java.util.List;

import lombok.Getter;

@Getter
public class RequestError {
    
    
    String error;
    String criterioRecibido;
    List<String> criteriosAceptados;

    public RequestError(String error, String criterioRecibido, List<String> criteriosAceptados) {
        this.error = error;
        this.criterioRecibido = criterioRecibido;
        this.criteriosAceptados = criteriosAceptados;
    }

    
}
