package br.com.ifood.tdd.workshop.domain.model

import kotlin.random.Random

object DriverTipFactory {

    fun make(
        value: Double = Random.nextDouble(),
    ) = DriverTip(
        value = value
    )
}