package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

class ServiceFeeDefaultCalculator(
    private val itemsValueCalculator: ItemsValueCalculator,
    private val calculatorRemoteConfigService: CalculatorRemoteConfigService
) : ServiceFeeCalculator {

    override fun calculate(
        cart: Cart
    ): Double = calculatorRemoteConfigService.getServiceFeeValue().takeIf {
        val itemsValue = itemsValueCalculator.calculate(cart)
        (itemsValue > 0 && itemsValue < 20.0)
    } ?: 0.0
}
