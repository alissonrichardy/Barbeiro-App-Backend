package br.com.zubcovsoft.barbeiroapp.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
