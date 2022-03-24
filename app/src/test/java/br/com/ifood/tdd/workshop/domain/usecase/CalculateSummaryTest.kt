package br.com.ifood.tdd.workshop.domain.usecase

import br.com.ifood.tdd.workshop.domain.model.CartFactory
import br.com.ifood.tdd.workshop.domain.model.ItemFactory
import br.com.ifood.tdd.workshop.domain.model.usecase.SummaryCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateSummaryTest {

    private val summaryCalculator: SummaryCalculator = SummaryCalculator()

    @Test
    fun calculateSummary_cartWithTwoItems_return_ten() {
        val cart = CartFactory.make(
            items = ItemFactory.makeList(
                count = 2,
                quantity = 1,
                unitValue = 5.0
            )
        )

        val actual: Double = summaryCalculator.calculateItemsValue(cart)

        assertEquals(10.0, actual)
    }

    @Test
    fun calculateSummary_cartWithoutItems_return_zero() {
        val cart = CartFactory.make(
            items = emptyList()
        )

        val actual: Double = summaryCalculator.calculateItemsValue(cart)

        assertEquals(0.0, actual)
    }


    @Test
    fun calculateSummary_cart_returnExpectedValues() {
        val cart = CartFactory.make()

        val actual: Double = summaryCalculator.calculateItemsValue(cart)
        val expected = cart.items.sumOf { it.quantity * it.unitValue }

        assertEquals(expected, actual)
    }

}