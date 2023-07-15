package com.veterinaria.entityClientes.repository;

import com.veterinaria.entityClientes.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {
}
