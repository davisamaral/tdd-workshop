package br.com.ifood.tdd.workshop

import br.com.ifood.tdd.workshop.domain.service.Example
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExperimentalCoroutinesApi
@DisplayName("Summary Calculator")
class ExampleTest {

    private val fixture = Example()

    @Nested
    @DisplayName("when calculate delivery fee")
    inner class DeliveryFee {

        @ParameterizedTest
        @ValueSource(doubles = [20.0, 20.01, 1000.0])
        @DisplayName("with values equals or grater than twenty then return zero")
        fun calculateDeliveryFee_valueEqualOrGraterThanTwenty_returnZero(orderValue: Double) =
            runTest {

                val actual = fixture.calculateDeliveryFee(orderValue)

                val expected = 0.0
                assertEquals(expected, actual)
            }

        @ParameterizedTest
        @ValueSource(doubles = [0.0, 5.01, 19.99])
        @DisplayName("with values less than twenty then return ten")
        fun calculateDeliveryFee_valueLessThanTwenty_returnTen(orderValue: Double) = runTest {
            val actual = fixture.calculateDeliveryFee(orderValue)

            val expected = 10.0

            assertEquals(expected, actual)
        }

    }
}