package ru.stimmax.ru.stimmax.lessons

import kotlin.enums.EnumEntries

// Перегрузка операторов
// 1  Доступ к элементу по индексу ([ ]) и проверка наличия через in
//Есть класс Inventory, внутри которого хранится список строк items.

class Inventory(val arg: MutableList<String>) {
    //Перегрузи оператор + чтобы добавлять новые элементы в список.
    operator fun plus(other: String) {
        arg.add(other)
    }

    //Перегрузи оператор [ ], чтобы получать предмет по индексу.
    operator fun get(index: Int): String{
        return arg[index]
    }

    //Перегрузи оператор in, чтобы проверять вхождение строки в список items.
    operator fun contains(other: String): Boolean {
        return other in arg
    }
}

// 2 Инверсия состояния (!)
//Есть класс Toggle с полем enabled: Boolean.
class Toggle(private val enabled: Boolean) {
    //Перегрузи оператор !, чтобы он возвращал новый объект с противоположным состоянием.
    operator fun not(): Toggle {
        return Toggle(!enabled)
    }

    override fun toString(): String {
        return enabled.toString()
    }
}


// 3 Умножение значения (*)
//Есть класс Price с полем amount: Int.
class Price(val amount: Int) {

    //Перегрузи оператор *, чтобы можно было умножать цену на целое число (например, количество товаров).
    operator fun times(other: Int): Int {
        return amount * other
    }
}
// 4 Диапазон значений (..)


//Есть класс Step с полем number: Int.
class Step(val number: Int) {
    //Перегрузи оператор .., чтобы можно было создавать диапазон шагов между двумя объектами Step.
    operator fun rangeTo(other: Step) = number..other.number


    //Сделай возможной проверку: входит ли один Step в диапазон шагов с помощью оператора in.
// Обрати внимание, что это обратная операция и нужно расширять класс IntRange для проверки вхождения в него Step.
    operator fun contains(range: IntRange) = number in range
}
    operator fun IntRange.contains(step: Step) = step.number in this

// 5 Последовательное объединение (+)

//Есть класс Log с полем entries: List<String>.
class Log(){
    private val entries = mutableListOf<String>()
    //Перегрузи оператор +, чтобы при сложении логов записи объединялись в один лог.
    operator fun plus(other: String): Log{
        entries + other
        return this
    }

    override fun toString(): String {
        return entries.toString()
    }
}


fun main() {
    val list = mutableListOf<String>("123wdewcsdcsc", "sdcsdcsdcs")

    val inventory = Inventory(list)
     inventory + "String"
    val get = inventory[1]
    println(get)
    val result = "d" in inventory
    println(result)

    val toggle = Toggle(true)
    println(!toggle)


    val price = Price(5)
    val result3 = price * 8
    println(result3)


    val step = Step(4)
    val step1 = Step(9)
    val range = step..step1
    println(range.toString())
    println(Step(5) in range)
    println(Step(15) in range)

    val log = Log()
    println(log + "1" + "2")
}