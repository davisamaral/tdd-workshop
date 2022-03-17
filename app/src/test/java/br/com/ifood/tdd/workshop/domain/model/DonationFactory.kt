package br.com.ifood.tdd.workshop.domain.model

import kotlin.random.Random

object DonationFactory {

    fun make(
        value: Double = Random.nextDouble(),
    ) = Donation(
        value = value
    )
}