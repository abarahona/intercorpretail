package com.intercorpretail.microservice.clienteservice.repository;

import com.intercorpretail.microservice.clienteservice.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
