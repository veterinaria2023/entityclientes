package com.veterinaria.entityClientes.controller;

import com.veterinaria.entityClientes.dto.ClientesDto;
import com.veterinaria.entityClientes.service.ClientesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
