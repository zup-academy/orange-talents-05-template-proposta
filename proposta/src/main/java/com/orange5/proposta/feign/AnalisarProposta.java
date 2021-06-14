package com.orange5.proposta.feign;

import com.orange5.proposta.dto.AnalisarPropostaRequest;
import com.orange5.proposta.dto.AnalisarPropostaResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url= "http://localhost:9999/api" , name = "analise-proposta")
public interface AnalisarProposta {
    
    @PostMapping("/solicitacao")
    AnalisarPropostaResponse analisarRequest(AnalisarPropostaRequest analisarPropostaRequest);
}
