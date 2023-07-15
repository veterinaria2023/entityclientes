package com.veterinaria.entityClientes.controller;

import com.veterinaria.entityClientes.dto.ClientesDto;
import com.veterinaria.entityClientes.service.ClientesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClientesService service;

    public ClienteController(ClientesService service) {
        this.service = service;
    }

    @GetMapping("/listaClientes")
    public List<ClientesDto> dtoList(){
        return this.service.listarClientes();
    }

    @GetMapping("/buscarCliente")
    public Optional<ClientesDto> clientesDto(@RequestParam("id") Long id){
        return this.service.buscarCliente(id);
    }
}
