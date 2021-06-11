package com.orange5.proposta.repository;

import java.util.Optional;

import com.orange5.proposta.entity.Proposta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    Optional<Proposta> findByCodigoPessoa(String codigoPessoa);

}
