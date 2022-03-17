package br.com.ifood.tdd.workshop.domain.model

data class Summary(
    val itemsValue: Double,
    val serviceFeeValue: Double,
    val deliveryFeeValue: Double,
    val donationValue: Double,
    val driverTipValue: Double,
    val subTotalValue: Double,
    val discountValue: Double,
    val walletBalanceValue: Double,
    val totalValue: Double,
)
