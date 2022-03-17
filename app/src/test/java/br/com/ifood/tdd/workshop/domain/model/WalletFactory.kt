package br.com.ifood.tdd.workshop.domain.model

import kotlin.random.Random

object WalletFactory {

    fun make(
        isSelected: Boolean = Random.nextBoolean(),
        balance: Double = Random.nextDouble(),
    ) = Wallet(
        isSelected = isSelected,
        balance = balance
    )
}