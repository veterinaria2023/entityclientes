package com.veterinaria.entityClientes.service;

import com.veterinaria.entityClientes.dto.ClientesDto;

import java.util.List;
import java.util.Optional;

public interface ClientesService {


    ClientesDto guardarCliente(ClientesDto request);

    List<ClientesDto> listarClientes();
    Optional<ClientesDto> buscarCliente(Long id);

    ClientesDto actualizarCliente(ClientesDto requestCliente, Long id);

    String eliminarCliente(Long id);
}
