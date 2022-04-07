package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

class ServiceFeeDefaultCalculator(
    private val itemsValueCalculator: ItemsValueCalculator,
    private val calculatorRemoteConfigService: CalculatorRemoteConfigService
) : ServiceFeeCalculator {

    override fun calculate(
        cart: Cart
    ): Double {
        val itemsValue = itemsValueCalculator.calculate(cart)
        return if (itemsValue < SERVICE_FEE_MIN_ITEM_VALUE && itemsValue > 0) {
            calculatorRemoteConfigService.getServiceFeeValue()
        } else {
            MIN_ITEM_VALUE_REACHED_SERVICE_FEE
        }
    }

    private companion object {
        private const val SERVICE_FEE_MIN = 0.0
        private const val SERVICE_FEE_MIN_ITEM_VALUE = 20.0
        private const val MIN_ITEM_VALUE_REACHED_SERVICE_FEE = 0.0
    }
}
