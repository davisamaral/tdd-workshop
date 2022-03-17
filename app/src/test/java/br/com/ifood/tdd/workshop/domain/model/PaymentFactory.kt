package br.com.ifood.tdd.workshop.domain.model

import br.com.ifood.tdd.workshop.extension.nextEnum
import br.com.ifood.tdd.workshop.extension.nextStringMap
import kotlin.random.Random

object PaymentFactory {

    fun make(
        type: Payment.Type = Random.nextEnum(Payment.Type::class.java),
        data: Map<String, String> = Random.nextStringMap()
    ) = Payment(
        type = type,
        data = data
    )
}