package br.com.ifood.tdd.workshop.domain.usecase

import br.com.ifood.tdd.workshop.domain.model.Address
import br.com.ifood.tdd.workshop.domain.model.usecase.CalculatorRemoteConfigService
import br.com.ifood.tdd.workshop.domain.model.usecase.DeliveryFeeCalculator
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class DeliveryFeeDefaultCalculatorTest {

    private val distanceCalculator = mockk<DistanceCalculator>()
    private val calculatorRemoteConfigService = mockk<CalculatorRemoteConfigService>()

    private val shortValue = 0.0
    private val mediumValue = 1.0
    private val largeValue = 3.0
    private val config: DeliveryFeeConfig = DeliveryFeeConfig(

    )

    private val calculator: DeliveryFeeCalculator = DeliveryFeeDefaultCalculator(
        distanceCalculator = distanceCalculator,
        calculatorRemoteConfigService = calculatorRemoteConfigService,
    )

    @Test
    fun calculate_withTakeawayDeliveryMethod_returnZero(){

    }

    @Test
    fun calculate_distanceLessThan2K_returnShortDistanceRemoteValue(){
        prepareScenario(distance= 1)

        calculator.calculate()
    }

    @Test
    fun calculate_distanceEquals2K_returnShortDistanceRemoteValue(){
        prepareScenario(distance= 2)

        calculator.calculate()
    }

    @Test
    fun calculate_distanceLessThanFive_returnMediumDistanceRemoteValue(){
        prepareScenario(distance= 4)

        calculator.calculate()
    }


    @Test
    fun calculate_distanceEqualFive_returnMediumDistanceRemoteValue(){
        prepareScenario(distance= 5)

        calculator.calculate()
    }


    @Test
    fun calculate_distanceGraterThanFive_returnLargeDistanceRemoteValue(){
        prepareScenario(distance= 8)

        calculator.calculate()
    }

    private fun prepareScenario(  distance: Int ){
        every {
            distanceCalculator.calculateDistanceInKm(any<Address>(), any<Address>())
        } returns distance

        every {
            calculatorRemoteConfigService.getDeliveryFeeConfig()
        } returns config
    }
}