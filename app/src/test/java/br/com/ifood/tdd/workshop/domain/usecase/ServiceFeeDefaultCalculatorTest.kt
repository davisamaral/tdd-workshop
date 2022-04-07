package br.com.ifood.tdd.workshop.domain.usecase

import br.com.ifood.tdd.workshop.domain.model.CartFactory
import br.com.ifood.tdd.workshop.domain.model.usecase.CalculatorRemoteConfigService
import br.com.ifood.tdd.workshop.domain.model.usecase.ItemsValueCalculator
import br.com.ifood.tdd.workshop.domain.model.usecase.ServiceFeeCalculator
import br.com.ifood.tdd.workshop.domain.model.usecase.ServiceFeeDefaultCalculator
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ServiceFeeDefaultCalculatorTest {

    private val itemsValueCalculator = mockk<ItemsValueCalculator>()
    private val calculatorRemoteConfigService = mockk<CalculatorRemoteConfigService>()

    private val calculator: ServiceFeeCalculator = ServiceFeeDefaultCalculator(
        itemsValueCalculator = itemsValueCalculator,
        calculatorRemoteConfigService = calculatorRemoteConfigService,
    )

    private val serviceValue = 8.0
    private val freeServiceValue = 0.0
    private val cart = CartFactory.make()

    @Test
    fun calculate_withItemsValueNegative_returnZeroServiceFeeValue() {
        prepareScenario(itemsValue = -5.0)

        val actual = calculator.calculate(cart)

        assertEquals(freeServiceValue, actual)
    }

    @Test
    fun calculate_withItemsValueEqualZero_returnZeroServiceFeeValue() {
        prepareScenario(itemsValue = 0.0)

        val actual = calculator.calculate(cart)

        assertEquals(freeServiceValue, actual)
    }

    @Test
    fun calculate_withItemsValueLessThanTwentyAndGraterThanZeroSomeDecimals_returnServiceFeeValue() {
        prepareScenario(itemsValue = 0.00000000001)

        val actual = calculator.calculate(cart)

        assertEquals(serviceValue, actual)
    }

    @Test
    fun calculate_withItemsValueLessThanTwentyAndGraterThanZero_returnServiceFeeValue() {
        prepareScenario(itemsValue = 5.0)

        val actual = calculator.calculate(cart)

        assertEquals(serviceValue, actual)
    }

    @Test
    fun calculate_withItemsValueLessThanTwentyWithManyDecimalsAndGraterThanZero_returnServiceFeeValue() {
        prepareScenario(itemsValue = 19.999999999999)

        val actual = calculator.calculate(cart)

        assertEquals(serviceValue, actual)
    }

    @Test
    fun calculate_withItemsValueEqualsTwenty_returnZeroServiceFeeValue() {
        prepareScenario(itemsValue = 20.0)

        val actual = calculator.calculate(cart)

        assertEquals(freeServiceValue, actual)
    }

    @Test
    fun calculate_withItemsGraterThanTwenty_returnZeroServiceFeeValue() {
        prepareScenario(itemsValue = 50.0)

        val actual = calculator.calculate(cart)

        assertEquals(freeServiceValue, actual)
    }

    private fun prepareScenario(
        itemsValue: Double
    ) {
        coEvery { itemsValueCalculator.calculate(cart) } returns itemsValue
        coEvery { calculatorRemoteConfigService.getServiceFeeValue() } returns serviceValue
    }
}