package com.veterinaria.entityClientes.service.impl;

import com.veterinaria.entityClientes.dto.ClientesDto;
import com.veterinaria.entityClientes.entity.ClientesEntity;
import com.veterinaria.entityClientes.repository.ClientesRepository;
import com.veterinaria.entityClientes.service.ClientesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository repository;

    public ClientesServiceImpl(ClientesRepository repository) {
        this.repository = repository;
    }


    @Override
    public ClientesDto guardarCliente(ClientesDto request) {

        ClientesEntity entity = ClientesEntity.builder()
                .nombre(request.getNombre())
                .direccion(request.getDireccion())
                .correo(request.getCorreo())
                .telefono(request.getTelefono())
                .comentario(request.getComentario())
                .build();
        ClientesEntity clientesEntity=  this.repository.save(entity);

        return ClientesDto.builder()
                .nombre(clientesEntity.getNombre())
                .direccion(clientesEntity.getDireccion())
                .correo(clientesEntity.getCorreo())
                .telefono(clientesEntity.getTelefono())
                .comentario(clientesEntity.getComentario())
                .build();
    }

    @Override
    public List<ClientesDto> listarClientes() {
        List<ClientesEntity> entity=this.repository.findAll();

        return entity.stream().map(entity1->{
            return ClientesDto.builder()
                    .nombre(entity1.getNombre())
                    .correo(entity1.getCorreo())
                    .telefono(entity1.getTelefono())
                    .direccion(entity1.getDireccion())
                    .comentario(entity1.getComentario())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientesDto> buscarCliente(Long id) {
        Optional<ClientesEntity> entity = this.repository.findById(id);

        return entity.map(clientesEntity -> {
            return ClientesDto.builder()
                    .nombre(clientesEntity.getNombre())
                    .direccion(clientesEntity.getDireccion())
                    .correo(clientesEntity.getCorreo())
                    .telefono(clientesEntity.getTelefono())
                    .comentario(clientesEntity.getComentario())
                    .build();
        });
    }

    @Override
    public ClientesDto actualizarCliente(ClientesDto requestCliente, Long id) {
        ClientesEntity entity = ClientesEntity.builder()
                .idClientes(id)
                .nombre(requestCliente.getNombre())
                .correo(requestCliente.getCorreo())
                .direccion(requestCliente.getDireccion())
                .comentario(requestCliente.getComentario())
                .telefono(requestCliente.getTelefono())
                .build();
        ClientesEntity clientesEntity= this.repository.save(entity);
        return ClientesDto.builder()
                .nombre(clientesEntity.getNombre())
                .direccion(clientesEntity.getDireccion())
                .correo(clientesEntity.getCorreo())
                .telefono(clientesEntity.getTelefono())
                .comentario(entity.getComentario())
                .build();
    }

    @Override
    public String eliminarCliente(Long id) {
        String response="";
        try {
            this.repository.deleteById(id);
            response="Cliente eliminado";
        }catch (Exception e){
            response= "Error al eliminar el cliente";
        }
        return response;
    }
}
