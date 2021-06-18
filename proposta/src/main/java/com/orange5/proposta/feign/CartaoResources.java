package com.orange5.proposta.feign;

import com.orange5.proposta.card.CardResponse;
import com.orange5.proposta.dto.CardBlockedRequest;
import com.orange5.proposta.dto.CardBlockedResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url= "http://localhost:8888/api" , name = "recursos-cartao")
public interface CartaoResources {
    
    @GetMapping("/cartoes?idProposta={id}")
    CardResponse getByPropostaId(@PathVariable("id") Long id);

    @PostMapping("/cartoes/{id}/bloqueios")
    CardBlockedResponse bloqueando(@PathVariable("id") String id, CardBlockedRequest cardBlockedRequest);
}
