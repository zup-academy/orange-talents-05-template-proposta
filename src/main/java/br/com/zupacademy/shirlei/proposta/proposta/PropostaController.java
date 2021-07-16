package br.com.zupacademy.shirlei.proposta.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired //injetando o repository
    private PropostaRepository propostaRepository;

    @PostMapping
    //@Transactional
    @CacheEvict(value = "listaPropostas", allEntries = true)
    public ResponseEntity cria(@RequestBody @Valid PropostaDTO propostaDTO, UriComponentsBuilder uriComponentsBuilder){
        Proposta proposta = propostaDTO.toModel();
        propostaRepository.save(proposta);

        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new PropostaDTO(proposta));
    }
}

//facilita o processo de criação de uri e url
//informo a uri que desejo construir