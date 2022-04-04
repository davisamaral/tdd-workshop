package br.com.ifood.tdd.workshop.domain.usecase

import br.com.ifood.tdd.workshop.domain.model.CartFactory
import br.com.ifood.tdd.workshop.domain.model.ItemFactory
import br.com.ifood.tdd.workshop.domain.model.usecase.ItemsValueDefaultCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ItemsValueDefaultCalculatorTest {

    private val itemsValueDefaultCalculator: ItemsValueDefaultCalculator = ItemsValueDefaultCalculator()

    @Test
    fun calculate_cartWithTwoItems_return_ten() {
        val cart = CartFactory.make(
            items = ItemFactory.makeList(
                count = 2,
                quantity = 1,
                unitValue = 5.0
            )
        )

        val actual: Double = itemsValueDefaultCalculator.calculate(cart)

        assertEquals(10.0, actual)
    }

    @Test
    fun calculate_cartWithoutItems_return_zero() {
        val cart = CartFactory.make(
            items = emptyList()
        )

        val actual: Double = itemsValueDefaultCalculator.calculate(cart)

        assertEquals(0.0, actual)
    }


    @Test
    fun calculate_cart_returnExpectedValues() {
        val cart = CartFactory.make()

        val actual: Double = itemsValueDefaultCalculator.calculate(cart)
        val expected = cart.items.sumOf { it.quantity * it.unitValue }

        assertEquals(expected, actual)
    }

}