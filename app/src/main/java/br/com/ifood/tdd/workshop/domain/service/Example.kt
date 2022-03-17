package br.com.ifood.tdd.workshop.domain.service

class Example {

    fun calculateDeliveryFee(orderValue: Double): Double {
        return if (orderValue >= 20.0) 0.0 else 10.0
    }
}
