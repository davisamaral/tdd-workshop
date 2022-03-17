package br.com.ifood.tdd.workshop.domain.service

import br.com.ifood.tdd.workshop.domain.model.Cart

class SummaryCalculatorService {

    fun calculateTotalItemsValue(cart: Cart): Double {
        return cart.items.sumOf { it.quantity * it.unitValue }
    }
}
