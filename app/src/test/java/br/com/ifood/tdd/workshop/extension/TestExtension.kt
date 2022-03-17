package br.com.ifood.tdd.workshop.extension

import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random
import kotlin.streams.asSequence


private val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

fun Random.nextString(length: Int = Random.nextInt(5, 12)) = ThreadLocalRandom.current()
    .ints(length.toLong(), 0, charPool.size)
    .asSequence()
    .map(charPool::get)
    .joinToString("")


fun Random.nextStringList(count: Int = nextInt(5, 10)) = mutableListOf<String>().apply {
    repeat(count) {
        add(nextString())
    }
}.toList()

fun Random.nextStringPhrase(
    numberOfWords: Int = nextInt(3, 7)
) = nextStringList(numberOfWords).joinToString(separator = " ")

fun Random.nextStringMap(
    count: Int = nextInt(5, 10)
) = nextStringList(count).associateBy { nextString() }

fun <T : Enum<*>> Random.nextEnum(clazz: Class<T>, except: List<T> = emptyList()): T {
    val result = clazz.enumConstants!!.random()
    return if (result !in except) result else nextEnum(clazz, except = except)
}
