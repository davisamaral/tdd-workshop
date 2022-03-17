package br.com.ifood.tdd.workshop.domain.model

data class Delivery(
    val mode: Mode,
) {
    enum class Mode {
        DELIVERY, TAKEAWAY
    }
}
