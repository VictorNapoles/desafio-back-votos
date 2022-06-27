package br.com.southsystem.desafiobackvotos.usecase.dto

import br.com.southsystem.desafiobackvotos.domain.Pauta

class CadastrarPautaDto(
    val texto: String,
){
    companion object{
        fun convertToDomain(dto: CadastrarPautaDto): Pauta{
            return Pauta(
                texto = dto.texto
            )
        }
    }
}
