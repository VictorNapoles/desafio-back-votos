package br.com.southsystem.desafiobackvotos.usecase.commons.exception
import org.springframework.http.HttpStatus
open class DefaultException: Exception {
    var statusCode: HttpStatus
        private set

    constructor(message: String, statusCode: HttpStatus) : super(message) {
        this.statusCode = statusCode
    };
    constructor(message: String, cause: Throwable, statusCode: HttpStatus) : super(message, cause) {
        this.statusCode = statusCode
    };
}