package br.com.ifood.tdd.workshop.domain.model

data class Address(
    val street: String,
    val number: String,
    val latitude: Double,
    val longitude: Double,
)