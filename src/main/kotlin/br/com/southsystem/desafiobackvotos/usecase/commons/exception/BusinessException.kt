package br.com.southsystem.desafiobackvotos.usecase.commons.exception

import org.springframework.http.HttpStatus

class BusinessException: DefaultException {
    constructor(message: String, statusCode: HttpStatus? = HttpStatus.UNPROCESSABLE_ENTITY) : super(message, statusCode!!);
    constructor(message: String, cause: Throwable, statusCode: HttpStatus? = HttpStatus.UNPROCESSABLE_ENTITY) : super(message, cause, statusCode!!);
}