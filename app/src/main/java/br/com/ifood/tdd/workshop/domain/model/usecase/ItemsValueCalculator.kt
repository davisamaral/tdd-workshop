package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

interface ItemsValueCalculator {

    fun calculate(cart: Cart): Double

}
