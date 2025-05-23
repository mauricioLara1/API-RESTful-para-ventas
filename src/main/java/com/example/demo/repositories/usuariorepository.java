package com.example.demo.repositories;

//list es la manera de hacer una lista de objetos (array flexible)
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.usuario;

//aqui se hace crea el repositorio de trabajo
@Repository
public interface usuariorepository extends JpaRepository<usuario, Integer> {
    
    // Buscar por nombre exacto
    List<usuario> findByNombre(String nombre);
    
    // Buscar por correo
    List<usuario> findByCorreo(String correo);

    //buscar por edad
    List<usuario> findByEdad(int edad);

    // Buscar por edad mayor a un número dado
    List<usuario> findByEdadGreaterThan(int edad);

    // Buscar usuarios con edad menor o igual
    List<usuario> findByEdadLessThanEqual(int edad);

    // Buscar por nombre que contenga una palabra (like '%nombre%')
    List<usuario> findByNombreContaining(String nombre);

}
