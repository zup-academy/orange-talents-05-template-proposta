package br.com.zupacademy.shirlei.proposta.Config;

import lombok.Data;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Data
public class Configs {

    @Autowired
    private Environment environment;

    @Value("${pass}")
    private String pass;

}
