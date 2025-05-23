package com.example.demo.services;

// Lista de usuarios
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.usuario;
import com.example.demo.repositories.usuariorepository;

// @Service marca esta clase como un servicio (Spring la reconoce y puede inyectarla)
@Service
public class usuarioservice {

    // Inyectamos el repositorio para usarlo aquí
    @Autowired
    private usuariorepository repositorio;
    //test
    public List<usuario> getUsuarios() {
        System.out.println("Llamada a getUsuarios desde el controlador");
        return repositorio.findAll();
    }
    
    // Obtener toda la tabla de usuarios
    public List<usuario> usuarios() {
        return repositorio.findAll();
    }

    // Buscar por ID
    public Optional<usuario> findByUsuarioId(int id) {
        return repositorio.findById(id);
    }

    // Guardar o actualizar un usuario
    public usuario saveUsuario(usuario user) {
        user.setEstado(true); // aseguramos que siempre se guarde como activo
        return repositorio.save(user);
    }
    

    // Eliminar por ID
    public void deleteUsuario(int id) {
        repositorio.deleteById(id);
    }

    // Buscar por nombre
    public List<usuario> findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    // Buscar por correo
    public List<usuario> findByCorreo(String correo) {
        return repositorio.findByCorreo(correo);
    }

    // Buscar por edad mayor
    public List<usuario> mayoresQue(int edad) {
        return repositorio.findByEdadGreaterThan(edad);
    }

    // Buscar por nombre que contenga
    public List<usuario> nombreContiene(String texto) {
        return repositorio.findByNombreContaining(texto);
    }
    public usuario updateUsuario(int id, usuario datosActualizados) {
        // Buscar el usuario existente por ID
        return repositorio.findById(id).map(usuarioExistente -> {
            // Actualizar los datos
            usuarioExistente.setNombre(datosActualizados.getNombre());
            usuarioExistente.setCorreo(datosActualizados.getCorreo());
            usuarioExistente.setedad(datosActualizados.getedad());
    
            // Guardar los cambios en la base de datos
            return repositorio.save(usuarioExistente);
        }).orElse(null); // Si no se encuentra el usuario, se retorna null
    }
    //borrado suave
    public usuario softDeleteUsuario(int id){
        Optional<usuario> usuario = repositorio.findById(id);
        if (usuario.isEmpty()){
            return null;
        }
        else{
            usuario borradosuave = usuario.get();
            if(borradosuave.getEstado()==false){
                borradosuave.setEstado(true);
                return repositorio.save(borradosuave);
            }
            else{
                borradosuave.setEstado(false);
                return repositorio.save(borradosuave);
            }
        }
    }
    
}
 