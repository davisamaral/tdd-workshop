package br.com.ifood.tdd.workshop.domain.model.usecase

import br.com.ifood.tdd.workshop.domain.model.Cart

interface DeliveryFeeCalculator {
    fun calculate(cart: Cart): Double
}