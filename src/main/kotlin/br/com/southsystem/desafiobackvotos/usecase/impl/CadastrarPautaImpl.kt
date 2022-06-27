package br.com.southsystem.desafiobackvotos.usecase.impl

import br.com.southsystem.desafiobackvotos.domain.Pauta
import br.com.southsystem.desafiobackvotos.gateway.database.PautaRepository
import br.com.southsystem.desafiobackvotos.usecase.CadastrarPauta
import br.com.southsystem.desafiobackvotos.usecase.commons.exception.ApplicationException
import br.com.southsystem.desafiobackvotos.usecase.dto.CadastrarPautaDto
import br.com.southsystem.desafiobackvotos.usecase.dto.PautaDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CadastrarPautaImpl(
    val pautaRepository: PautaRepository
): CadastrarPauta {

    private val logger = LoggerFactory.getLogger(CadastrarPautaImpl::class.java)

    override fun execute(source: CadastrarPautaDto): Mono<PautaDto> {
        return  Mono.just(source)
            .map(CadastrarPautaDto::convertToDomain)
            .flatMap(this::salvarPauta)
            .map(PautaDto::convertFromDomain)
    }

    private fun salvarPauta(pauta: Pauta) = this.pautaRepository.save(pauta)
        .doOnSuccess { pauta ->
            logger.info("Pauta cadastrada com sucesso: ", pauta)
        }
        .doOnError { ex ->
            logger.error(mensagemErroCadastrarPauta, ex)
        }
        .onErrorMap { ex ->
            ApplicationException(
                message = mensagemErroCadastrarPauta,
                cause = ex
            )
        }

    companion object{
        private const val mensagemErroCadastrarPauta = "Erro ao cadastrar a pauta"
    }
}