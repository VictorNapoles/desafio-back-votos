package br.com.southsystem.desafiobackvotos.usecase.commons.exception

import org.springframework.http.HttpStatus

class ItemNotFoundException: DefaultException {
    constructor(message: String, statusCode: HttpStatus? = HttpStatus.NOT_FOUND) : super(message, statusCode!!);
    constructor(message: String, cause: Throwable, statusCode: HttpStatus? = HttpStatus.NOT_FOUND) : super(message, cause, statusCode!!);
}