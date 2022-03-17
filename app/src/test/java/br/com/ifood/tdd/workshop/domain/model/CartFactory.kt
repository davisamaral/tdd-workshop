package br.com.ifood.tdd.workshop.domain.model

object CartFactory {

    fun make(
        customerAddress: Address = AddressFactory.make(),
        merchantAddress: Address = AddressFactory.make(),
        delivery: Delivery = DeliveryFactory.make(),
        donation: Donation = DonationFactory.make(),
        driverTip: DriverTip = DriverTipFactory.make(),
        items: List<Item> = ItemFactory.makeList(),
        payment: Payment = PaymentFactory.make(),
        voucher: Voucher = VoucherFactory.make(),
        wallet: Wallet = WalletFactory.make(),
    ) = Cart(
        customerAddress = customerAddress,
        merchantAddress = merchantAddress,
        delivery = delivery,
        donation = donation,
        driverTip = driverTip,
        items = items,
        payment = payment,
        voucher = voucher,
        wallet = wallet,
    )
}