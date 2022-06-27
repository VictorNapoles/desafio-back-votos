package br.com.southsystem.desafiobackvotos.gateway.http

import br.com.southsystem.desafiobackvotos.gateway.http.dto.CadastrarPautaRequestDto
import br.com.southsystem.desafiobackvotos.gateway.http.dto.PautaResponseDto
import br.com.southsystem.desafiobackvotos.usecase.CadastrarPauta
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/pautas")
class PautaController(
    val cadastrarPauta: CadastrarPauta
) {
    fun cadastrarPauta(request: Mono<CadastrarPautaRequestDto>): Mono<PautaResponseDto> {
        return request
            .map(CadastrarPautaRequestDto::convertToUsecaseDto)
            .flatMap(this.cadastrarPauta::execute)
            .map(PautaResponseDto::convertFromUsecaseDto)
    }
}