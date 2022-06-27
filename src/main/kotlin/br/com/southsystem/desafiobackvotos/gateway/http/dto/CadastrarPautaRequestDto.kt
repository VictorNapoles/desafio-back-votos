package br.com.southsystem.desafiobackvotos.gateway.http.dto

import br.com.southsystem.desafiobackvotos.usecase.dto.CadastrarPautaDto

class CadastrarPautaRequestDto(
    val texto: String,
){
    companion object{
        fun convertToUsecaseDto(dto: CadastrarPautaRequestDto): CadastrarPautaDto {
            return CadastrarPautaDto(
                texto = dto.texto
            )
        }
    }
}