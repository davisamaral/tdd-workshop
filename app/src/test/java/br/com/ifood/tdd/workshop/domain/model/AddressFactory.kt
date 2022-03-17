package br.com.ifood.tdd.workshop.domain.model

import br.com.ifood.tdd.workshop.extension.nextString
import br.com.ifood.tdd.workshop.extension.nextStringPhrase
import kotlin.random.Random

object AddressFactory {

    fun make(
        street: String = Random.nextStringPhrase(),
        number: String = Random.nextString(),
        latitude: Double = Random.nextDouble(),
        longitude: Double = Random.nextDouble(),
    ) = Address(
        street = street,
        number = number,
        latitude = latitude,
        longitude = longitude,
    )
}