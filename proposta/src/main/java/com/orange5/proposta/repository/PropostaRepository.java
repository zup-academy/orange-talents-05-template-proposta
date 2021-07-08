package com.orange5.proposta.repository;

import java.util.List;
import java.util.Optional;

import com.orange5.proposta.entity.Proposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    Optional<Proposta> findByCodigoPessoa(String codigoPessoa);

    @Query("SELECT p FROM Proposta p WHERE p.status = 'ELEGIVEL' and p.card is NULL")
    List<Proposta> findAprovados();

}
