package org.homework.lesson04

import kotlin.random.Random

// Генератор фраз.
//Используй класс Person из "общих рекомендаций" ниже. Добавь в этот класс три инфиксные функции:
class Person(private val name: String) {

    private val phrases = mutableListOf<String>()

    fun print() {
        println(phrases.joinToString(" "))
    }

    private fun selectPhrase(first: String, second: String): String {
        val random = Random.nextInt(0, 2)
        return if (random == 0) first else second
    }

    //says должна принимать строку, добавлять её в список фраз и возвращать этот же объект Person для
    // дальнейшей работы.
// Всегда вызывается первой.
    infix fun says(arg: String): Person {
        phrases.add(arg)
        return this
    }
    //and работает так же как и says, но не может быть вызвана первой (в этом случае нужно выкидывать
    // IllegalStateException).
    infix fun and(phase: String) : Person{
        check(phrases.isNotEmpty()) { IllegalStateException() }
        phrases.add(phase)
        return this
    }
    //or должна принимать строку и заменять последнюю фразу в списке фраз, выбирая случайным образом
    // переданную строку или
// последнюю фразу из списка фраз с помощью метода selectPhrase.
// Так же должна возвращать текущий объект Person для дальнейшей работы.
// Так же не может быть вызвана первой, иначе выбрасывает IllegalStateException.
    infix fun or(phase: String) : Person{
        check(phrases.isNotEmpty()) { IllegalStateException()}
        val phase1 = phase.split(" ")
        selectPhrase(
            phase,
            phase1.last()
        )
        return this
    }

}

fun main() {
    val andrew = Person("Andrew")
    andrew says "Hello" and "brothers." or "sisters." and "I believe" and "you" and "can do it" or "can't"
    andrew.print()
}