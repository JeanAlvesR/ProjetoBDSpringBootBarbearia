package Nexos.rest.controller;

import Nexos.exceptions.BadRequestException;
import Nexos.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ApplicationControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBadRequestException(BadRequestException erro){
        String mensagemErro = erro.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
