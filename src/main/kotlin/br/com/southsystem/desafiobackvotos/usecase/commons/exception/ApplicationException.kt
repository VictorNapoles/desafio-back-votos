package br.com.southsystem.desafiobackvotos.usecase.commons.exception

import org.springframework.http.HttpStatus

class ApplicationException: DefaultException {
    constructor(message: String, statusCode: HttpStatus? = HttpStatus.INTERNAL_SERVER_ERROR) : super(message, statusCode!!);
    constructor(message: String, cause: Throwable, statusCode: HttpStatus? = HttpStatus.INTERNAL_SERVER_ERROR) : super(message, cause, statusCode!!);
}