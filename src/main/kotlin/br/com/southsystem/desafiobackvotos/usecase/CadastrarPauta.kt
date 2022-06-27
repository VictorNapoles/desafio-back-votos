package br.com.southsystem.desafiobackvotos.usecase

import br.com.southsystem.desafiobackvotos.usecase.commons.Usecase
import br.com.southsystem.desafiobackvotos.usecase.dto.CadastrarPautaDto
import br.com.southsystem.desafiobackvotos.usecase.dto.PautaDto
import reactor.core.publisher.Mono

interface CadastrarPauta: Usecase<CadastrarPautaDto, Mono<PautaDto>> {
}