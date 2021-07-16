package br.com.zupacademy.shirlei.proposta.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

//Criado para fazer tratamento de erro

@RestControllerAdvice // Estou criando um api rest, logo, o uso do rest antes do ControllerAdvice
public class ErroHandler {

    @Autowired //para injetar as dependências
    private MessageSource messageSource; // classe do spring que me ajuda a pegar mensagens de erro.

    @ResponseStatus(HttpStatus.BAD_REQUEST) // informo qual o status ele deve me devolver em caso de erro
    @ExceptionHandler(MethodArgumentNotValidException.class) //informa ao spring que esse método deve ser chamado quando houver uma exceção em um dos controllers //O parametro é para indicar o tipo de exceção que deve ser lançada
    public List<ErroApi>handle(MethodArgumentNotValidException exception){// ele vai devolver uma lista com cada um dos erros que estão acontecendo. é um objeto armazenando os erros

        List<ErroApi>dto=new ArrayList<>(); // para que o retorno seja a minha lista de erros
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors(); //getBindingResult() = método com resultado das validações. //getFieldErrors() = contem todos os erros de formulários que aconteceram //FieldError + variavel local para armazenar

        fieldErrors.forEach(e -> { // o forEach para percorrer a minha lista
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); //para pegar a mensagem de erro //LocaleContextHolder.getLocale() para descobrir qual o local atual para gerar a mensagem no idioma correto.
            ErroApi erro = new ErroApi(e.getField(), mensagem);
            dto.add(erro); // pego o meu dto e adiciono a mensagem de erro
        });
        return dto;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handle(HttpMessageNotReadableException exception){

        return "HttpMessageNotReadableException: mensagem" + exception.getMessage() + "|| "+ exception.getHttpInputMessage();
    }
}
