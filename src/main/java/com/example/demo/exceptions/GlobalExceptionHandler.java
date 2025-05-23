// Este archivo está en el paquete de excepciones del proyecto
package com.example.demo.exceptions;

//imports y para que son
//Logger: permite crear un obj que escribe mensajes en la consola
//LoggerFactory:crea un logger para una clase especifica
//HttpStatus:representa los codigos http que de la app
//ResponseEntity:permite devolver respuestas perzonadas con un body y codigo http
//ExceptionHandler:se encarga de marcar un metodo que atrape errores especificos
//RestControllerAdvice:es para manejar los errores de todos los controladores

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

// Esta clase captura errores globales en la aplicación
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Logger: permite imprimir en consola lo que ocurre cuando hay errores
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Este método captura cualquier error NO específico
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        logger.error("Error interno del servidor", ex);
        return new ResponseEntity<>("Error interno: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Cuando un objeto que se espera no fue encontrado (por ejemplo en base de datos)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        logger.warn("Entidad no encontrada", ex);
        return new ResponseEntity<>("Recurso no encontrado: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Cuando los datos enviados violan reglas de la base de datos (como duplicados)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        logger.warn("Violación de integridad de datos", ex);
        return new ResponseEntity<>("Datos inválidos o repetidos: " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    // Cuando los datos enviados no pasan las validaciones (por ejemplo campos vacíos, mal formateados)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        logger.warn("Error de validación", ex);
        String errorMsg = ex.getBindingResult()
                            .getFieldErrors()
                            .stream()
                            .map(error -> error.getField() + ": " + error.getDefaultMessage())
                            .findFirst()
                            .orElse("Datos inválidos");
        return new ResponseEntity<>("Error de validación: " + errorMsg, HttpStatus.BAD_REQUEST);
    }
}
