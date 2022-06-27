package br.com.southsystem.desafiobackvotos.gateway.http.dto

import br.com.southsystem.desafiobackvotos.usecase.dto.PautaDto

class PautaResponseDto (
    val id: Long,
    val texto: String,
) {
    companion object {
        fun convertFromUsecaseDto(dto: PautaDto): PautaResponseDto {
            return PautaResponseDto(
                id = dto.id,
                texto = dto.texto
            )
        }
    }
}