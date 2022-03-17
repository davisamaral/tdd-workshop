package br.com.ifood.tdd.workshop.domain.model

import br.com.ifood.tdd.workshop.extension.nextString
import kotlin.random.Random

object VoucherFactory {

    fun make(
        code: String = Random.nextString(),
        value: Double = Random.nextDouble(),
    ) = Voucher(
        code = code,
        value = value
    )
}