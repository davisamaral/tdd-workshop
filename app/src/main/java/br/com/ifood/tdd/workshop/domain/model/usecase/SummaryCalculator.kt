package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

class SummaryCalculator {

    fun calculateItemsValue(cart: Cart) = cart.items.sumOf { (it.quantity * it.unitValue) }

}
