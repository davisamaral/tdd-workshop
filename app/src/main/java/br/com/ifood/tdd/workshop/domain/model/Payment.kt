package br.com.ifood.tdd.workshop.domain.model


data class Payment(
    val type: Type,
    val data: Map<String, String>
) {
    enum class Type {
        ONLINE, OFFLINE
    }
}