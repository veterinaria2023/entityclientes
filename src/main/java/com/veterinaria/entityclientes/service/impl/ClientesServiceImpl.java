package com.veterinaria.entityclientes.service.impl;

import com.veterinaria.entityclientes.dto.ClientesDto;
import com.veterinaria.entityclientes.entity.ClientesEntity;
import com.veterinaria.entityclientes.repository.ClientesRepository;
import com.veterinaria.entityclientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase que implementa la interface ClientesService
 * @see ClientesService
 * @version 1.0, 20/09/2021
 * @autor
 * @since 1.0
 * @see com.veterinaria.entityclientes.service.impl
 * @see com.veterinaria.entityclientes.dto
 * @see com.veterinaria.entityclientes.entity
 * @see com.veterinaria.entityclientes.repository
 * @see com.veterinaria.entityclientes.service
 *
 */
@Service // Anotacion para indicar que es un servicio
public class ClientesServiceImpl implements ClientesService { // Clase que implementa la interface ClientesService

    private final ClientesRepository repository; // Para inyectar la dependencia de la clase ClientesRepository

    @Autowired
    public ClientesServiceImpl(ClientesRepository repository) {
        this.repository = repository;
    } // Constructor de la clase ClientesServiceImpl


    @Override // Anotacion para indicar que se sobreescribe un metodo
    public ClientesDto guardarCliente(ClientesDto request) { // Metodo para guardar un cliente

        ClientesEntity entity = ClientesEntity.builder()
                .nombre(request.getNombre())
                .direccion(request.getDireccion())
                .correo(request.getCorreo())
                .telefono(request.getTelefono())
                .comentario(request.getComentario())
                .build(); // Se crea un objeto de tipo ClientesEntity por medio del constructor de la clase ClientesEntity con ayuda del builder
        ClientesEntity clientesEntity=  this.repository.save(entity); // Se guarda el objeto entity en la base de datos por medio del metodo save de la clase ClientesRepository

        return ClientesDto.builder()
                .nombre(clientesEntity.getNombre())
                .direccion(clientesEntity.getDireccion())
                .correo(clientesEntity.getCorreo())
                .telefono(clientesEntity.getTelefono())
                .comentario(clientesEntity.getComentario())
                .build(); // Se retorna un objeto de tipo ClientesDto por medio del constructor de la clase ClientesDto con ayuda del builder
    }

    @Override // Anotacion para indicar que se sobreescribe un metodo
    public List<ClientesDto> listarClientes() { // Metodo para listar los clientes
        List<ClientesEntity> entity=this.repository.findAll(); // Se crea una lista de objetos de tipo ClientesEntity por medio del metodo findAll de la clase ClientesRepository

        return entity.stream().map(entity1->{ // Se retorna una lista de objetos de tipo ClientesDto por medio del metodo map de la clase Stream
            return ClientesDto.builder()
                    .nombre(entity1.getNombre())
                    .correo(entity1.getCorreo())
                    .telefono(entity1.getTelefono())
                    .direccion(entity1.getDireccion())
                    .comentario(entity1.getComentario())
                    .build(); // Se retorna un objeto de tipo ClientesDto por medio del constructor de la clase ClientesDto con ayuda del builder
        }).collect(Collectors.toList()); // Se retorna una lista de objetos de tipo ClientesDto por medio del metodo toList de la clase Collectors
    }

    @Override // Anotacion para indicar que se sobreescribe un metodo
    public Optional<ClientesDto> buscarCliente(Long id) { // Metodo para buscar un cliente por su id
        Optional<ClientesEntity> entity = this.repository.findById(id); // Se crea un objeto de tipo Optional de ClientesEntity por medio del metodo findById de la clase ClientesRepository

        return entity.map(clientesEntity -> {
            return ClientesDto.builder()
                    .nombre(clientesEntity.getNombre())
                    .direccion(clientesEntity.getDireccion())
                    .correo(clientesEntity.getCorreo())
                    .telefono(clientesEntity.getTelefono())
                    .comentario(clientesEntity.getComentario())
                    .build(); // se implimentara el patron dto para el manejo de datos retornando un objeto de tipo ClientesDto por medio del constructor de la clase ClientesDto con ayuda del builder
        });
    }

    @Override // Anotacion para indicar que se sobreescribe un metodo
    public ClientesDto actualizarCliente(ClientesDto requestCliente, Long id) { // Metodo para actualizar un cliente
        ClientesEntity entity = ClientesEntity.builder()
                .idClientes(id)
                .nombre(requestCliente.getNombre())
                .correo(requestCliente.getCorreo())
                .direccion(requestCliente.getDireccion())
                .comentario(requestCliente.getComentario())
                .telefono(requestCliente.getTelefono())
                .build(); // Se crea un objeto de tipo ClientesEntity por medio del constructor de la clase ClientesEntity con ayuda del builder
        ClientesEntity clientesEntity= this.repository.save(entity); // Se guarda el objeto entity en la base de datos por medio del metodo save de la clase ClientesRepository
        return ClientesDto.builder() // Se retorna un objeto de tipo ClientesDto por medio del constructor de la clase ClientesDto con ayuda del builder
                .nombre(clientesEntity.getNombre())
                .direccion(clientesEntity.getDireccion())
                .correo(clientesEntity.getCorreo())
                .telefono(clientesEntity.getTelefono())
                .comentario(entity.getComentario())
                .build(); // Se retorna un objeto de tipo ClientesDto por medio del constructor de la clase ClientesDto con ayuda del builder
    }

    @Override // Anotacion para indicar que se sobreescribe un metodo
    public String eliminarCliente(Long id) {  // Metodo para eliminar un cliente
        String response=""; // Se crea un objeto de tipo String
        try { // Se maneja una excepcion
            this.repository.deleteById(id); // Se elimina un cliente por medio del metodo deleteById de la clase ClientesRepository
            response="Cliente eliminado"; // Se asigna un valor al objeto response
        }catch (Exception e){ // Se captura la excepcion
            response= "Error al eliminar el cliente"; // Se asigna un valor al objeto response
        }
        return response; // Se retorna un objeto de tipo String
    }
}
