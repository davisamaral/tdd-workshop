package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

class ItemsValueDefaultCalculator : ItemsValueCalculator {

    override fun calculate(cart: Cart) = cart.items.sumOf { (it.quantity * it.unitValue) }
}
