package com.orange5.proposta.feign;

import com.orange5.proposta.card.CardResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "http://localhost:8888/api" , name = "recursos-cartao")
public interface CartaoResources {
    
    @GetMapping("/cartoes?idProposta={id}")
    CardResponse getByPropostaId(@PathVariable("id") Long id);
}
