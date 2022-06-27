package br.com.southsystem.desafiobackvotos.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class Pauta(

    @Id
    val id: Long? = null,

    @Column
    val texto: String,
){
    override fun toString(): String {
        return "Pauta(id=$id, texto='$texto')"
    }
}