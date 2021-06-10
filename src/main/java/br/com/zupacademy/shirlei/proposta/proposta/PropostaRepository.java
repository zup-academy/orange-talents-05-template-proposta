package br.com.zupacademy.shirlei.proposta.proposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    @Query(value = "SELECT LAST_INSERT_ID() FROM proposta as p", nativeQuery = true)
    Long getLastId();
    Optional<Proposta> findByDocumento(String documento);
}