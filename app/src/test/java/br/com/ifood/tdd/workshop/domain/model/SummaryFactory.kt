package br.com.ifood.tdd.workshop.domain.model

import kotlin.random.Random

object SummaryFactory {

    fun make(
        itemsValue: Double = Random.nextDouble(),
        serviceFeeValue: Double = Random.nextDouble(),
        deliveryFeeValue: Double = Random.nextDouble(),
        donationValue: Double = Random.nextDouble(),
        driverTipValue: Double = Random.nextDouble(),
        subTotalValue: Double = Random.nextDouble(),
        discountValue: Double = Random.nextDouble(),
        walletBalanceValue: Double = Random.nextDouble(),
        totalValue: Double = Random.nextDouble(),
    ) = Summary(
        itemsValue = itemsValue,
        serviceFeeValue = serviceFeeValue,
        deliveryFeeValue = deliveryFeeValue,
        donationValue = donationValue,
        driverTipValue = driverTipValue,
        subTotalValue = subTotalValue,
        discountValue = discountValue,
        walletBalanceValue = walletBalanceValue,
        totalValue = totalValue,
    )
}