package br.com.ifood.tdd.workshop.domain.model

data class Cart(
    val customerAddress: Address,
    val merchantAddress: Address,
    val delivery: Delivery,
    val donation: Donation,
    val driverTip: DriverTip,
    val items: List<Item>,
    val payment: Payment,
    val voucher: Voucher,
    val wallet: Wallet,
)