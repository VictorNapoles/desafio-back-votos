package br.com.southsystem.desafiobackvotos.gateway.http.handler

import br.com.southsystem.desafiobackvotos.gateway.http.dto.ErrorDto
import br.com.southsystem.desafiobackvotos.usecase.commons.exception.ApplicationException
import br.com.southsystem.desafiobackvotos.usecase.commons.exception.BusinessException
import br.com.southsystem.desafiobackvotos.usecase.commons.exception.DefaultException
import br.com.southsystem.desafiobackvotos.usecase.commons.exception.ItemNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import reactor.core.publisher.Mono

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun serverExceptionHandler(ex: BusinessException): Mono<ResponseEntity<ErrorDto>> {
        return this.doHandle(ex)
    }

    @ExceptionHandler(ApplicationException::class)
    fun serverExceptionHandler(ex: ApplicationException): Mono<ResponseEntity<ErrorDto>> {
        return this.doHandle(ex)
    }

    @ExceptionHandler(ItemNotFoundException::class)
    fun serverExceptionHandler(ex: ItemNotFoundException): Mono<ResponseEntity<ErrorDto>> {
        return this.doHandle(ex)
    }

    private fun doHandle(ex: DefaultException): Mono<ResponseEntity<ErrorDto>>{
        return Mono.just(ex)
            .map { ResponseEntity<ErrorDto>(ErrorDto.convertFromException(ex), ex.statusCode) }
    }
}