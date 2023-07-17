package com.veterinaria.entityclientes.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ClientesDto {

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String comentario;
}
