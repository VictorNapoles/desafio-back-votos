package br.com.southsystem.desafiobackvotos.gateway.http.dto

import com.fasterxml.jackson.annotation.JsonInclude

class ErrorDto (
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val message: String? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val cause: Throwable? = null
){
    companion object{
        fun convertFromException(exception: Exception): ErrorDto {
            return ErrorDto(
                message = exception.message,
                cause = exception.cause,
            )
        }
    }
}