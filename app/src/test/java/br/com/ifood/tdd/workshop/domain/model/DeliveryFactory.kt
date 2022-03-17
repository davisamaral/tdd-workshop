package br.com.ifood.tdd.workshop.domain.model

import br.com.ifood.tdd.workshop.extension.nextEnum
import kotlin.random.Random

object DeliveryFactory {

    fun make(
        mode: Delivery.Mode = Random.nextEnum(Delivery.Mode::class.java),
    ) = Delivery(
        mode = mode,
    )
}