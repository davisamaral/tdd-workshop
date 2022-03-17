package br.com.ifood.tdd.workshop.domain.model

import br.com.ifood.tdd.workshop.extension.nextString
import kotlin.random.Random

object ItemFactory {

    fun make(
        name: String = Random.nextString(),
        quantity: Int = Random.nextInt(),
        unitValue: Double = Random.nextDouble(),
    ) = Item(
        name = name,
        quantity = quantity,
        unitValue = unitValue,
    )

    fun makeList(
        count: Int = Random.nextInt(2, 10),
        quantity: Int? = null,
        unitValue: Double? = null,
    ) = mutableListOf<Item>().apply {
        repeat(count) {
            val safeQuantity = quantity ?: Random.nextInt()
            val safeUnitValue = unitValue ?: Random.nextDouble()
            add(make(quantity = safeQuantity, unitValue = safeUnitValue))
        }
    }.toList()
}