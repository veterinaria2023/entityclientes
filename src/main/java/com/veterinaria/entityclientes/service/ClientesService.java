package com.veterinaria.entityclientes.service;

import com.veterinaria.entityclientes.dto.ClientesDto;

import java.util.List;
import java.util.Optional;

// Interface de servicio para la entidad Clientes
public interface ClientesService {


    ClientesDto guardarCliente(ClientesDto request); // Metodo para guardar un cliente

    List<ClientesDto> listarClientes(); // Metodo para listar los clientes
    Optional<ClientesDto> buscarCliente(Long id); // Metodo para buscar un cliente por su id

    ClientesDto actualizarCliente(ClientesDto requestCliente, Long id); // Metodo para actualizar un cliente

    String eliminarCliente(Long id); // Metodo para eliminar un cliente
}
