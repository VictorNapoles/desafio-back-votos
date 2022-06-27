package br.com.southsystem.desafiobackvotos.usecase.dto

import br.com.southsystem.desafiobackvotos.domain.Pauta

class PautaDto(
    val id: Long,
    val texto: String,
){
    companion object{
        fun convertFromDomain(domain: Pauta): PautaDto {
            return PautaDto(
                id = domain.id!!,
                texto = domain.texto
            )
        }
    }
}
