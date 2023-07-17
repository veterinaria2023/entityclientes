package com.veterinaria.entityclientes.entity;




import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;




@Entity
@Table(name = "clientes", schema = "veterinaria")
@Getter
@Setter
@Builder
public class ClientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclientes")
    private Long idClientes;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "comentario", length = 45)
    private String comentario;

    public ClientesEntity() {
        super();
    }

    public ClientesEntity(Long idClientes, String nombre, String direccion, String telefono, String correo, String comentario) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.comentario = comentario;
    }
}
