package com.veterinaria.entityclientes.repository;

import com.veterinaria.entityclientes.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa la interface JpaRepository
 *
 */
@Repository // Anotacion para indicar que es un repositorio
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> { // Clase que implementa la interface JpaRepository
}
