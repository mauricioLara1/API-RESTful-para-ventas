package com.example.demo.controllers;

// Importaciones necesarias
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.usuario;
import com.example.demo.services.usuarioservice;

// Este controlador escucha las solicitudes HTTP relacionadas con "usuario"
@RestController
@RequestMapping("/usuarios") // Ruta base para este controlador: http://localhost:8080/usuarios
public class usuariocontroller {

    // Inyectamos el servicio para poder usar sus métodos
    @Autowired
    private usuarioservice servicio;

    //Obtener todos los usuarios (GET)
    @GetMapping
    public List<usuario> getUsuarios() {
        return servicio.getUsuarios();
    }
    //Obtener un usuario por su ID (GET)
    //http://localhost:8081/usuarios/1
    @GetMapping("/{id}")
    public Optional<usuario> getUsuarioById(@PathVariable int id) {
        Optional<usuario> usuario =  servicio.findByUsuarioId(id);
        return usuario;
    }
    //Buscar usuarios por correo (GET)
    //para usar el parámetro se escribe la URL así:
    //http://localhost:8081/usuarios/buscar?correo=postman@postman.com
    @GetMapping("/buscar")
    public List<usuario> findByCorreo(@RequestParam String correo) {
        return servicio.findByCorreo(correo);
    }

    // Crear un nuevo usuario (POST)
    @PostMapping
    public usuario saveUsuario(@RequestBody usuario usuarioNuevo) {
        return servicio.saveUsuario(usuarioNuevo);
    }

    // Actualizar un usuario existente (PUT)
    @PutMapping("/{id}")
    public usuario actualizarUsuario(@PathVariable int id, @RequestBody usuario usuarioActualizado) {
        return servicio.updateUsuario(id, usuarioActualizado);
    }
    //borrado suave un usuario
    @PutMapping("borradoSuave/{id}")
    public usuario borradoSuaveUsuario(@PathVariable int id) {
        return servicio.softDeleteUsuario(id);
    }



    // Eliminar un usuario por su ID (DELETE)
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id) {
        servicio.deleteUsuario(id);
    }

}
