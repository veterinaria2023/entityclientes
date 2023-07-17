package com.veterinaria.entityclientes.controller;

import com.veterinaria.entityclientes.dto.ClientesDto;
import com.veterinaria.entityclientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//*@RestController: Es una anotación de conveniencia que agrega las anotaciones @Controller y @ResponseBody.
@RestController
@RequestMapping("/api/clientes") //* @RequestMapping: Proporciona la anotación de nivel de clase para especificar las rutas de solicitud que manejará un controlador.
public class ClienteController {

    private final ClientesService service; //* Para inyectar la dependencia de la clase ClientesService
    @Autowired
    public ClienteController(ClientesService service) {
        this.service = service;
    } //* Constructor de la clase ClienteController


    @GetMapping("/listaClientes") //* @GetMapping: Anotación para mapear solicitudes HTTP GET en métodos de controlador específicos.
    public List<ClientesDto> dtoList(){
        return this.service.listarClientes();
    } //* Método para listar los clientes

    @GetMapping("/buscarCliente") //* @GetMapping: Anotación para mapear solicitudes HTTP GET en métodos de controlador específicos.
    public Optional<ClientesDto> clientesDto(@RequestParam("id") Long id){
        return this.service.buscarCliente(id);
    } //* Método para buscar un cliente por su id

    @PostMapping("/guardarCliente") //* @PostMapping: Anotación para mapear solicitudes HTTP POST en métodos de controlador específicos.
    public ClientesDto guardarCliente(@RequestBody ClientesDto requestClinete){ //* @RequestBody: Anotación que indica que un parámetro del controlador debe estar vinculado al cuerpo web de la solicitud.
        return this.service.guardarCliente(requestClinete); //* Método para guardar un cliente
    }

    @PutMapping("/actualizarCliete") //* @PostMapping: Anotación para mapear solicitudes HTTP POST en métodos de controlador específicos.
    public ClientesDto actualizarCliente(@RequestBody ClientesDto requestClinte, Long id){ //* @RequestBody: Anotación que indica que un parámetro del controlador debe estar vinculado al cuerpo web de la solicitud.
        return this.service.actualizarCliente(requestClinte, id); //* Método para actualizar un cliente
    }

    @DeleteMapping("/eliminarCliente") //* @GetMapping: Anotación para mapear solicitudes HTTP GET en métodos de controlador específicos.
    public String eliminarCliente(@RequestParam("id") Long id){ //* @RequestParam: Anotación que indica que un parámetro del controlador debe estar vinculado a un parámetro de consulta web.
        return this.service.eliminarCliente(id); //* Método para eliminar un cliente
    }
}
