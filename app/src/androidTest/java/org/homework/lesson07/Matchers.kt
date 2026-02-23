package org.homework.lesson07

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeDiagnosingMatcher

// Задание: Разработка пользовательских матчеров для геометрических фигур
//В этом задании тебе предстоит разработать несколько пользовательских матчеров, используя библиотеку Hamcrest.
// Они должны проверять валидность геометрических фигур на основе заданных критериев.

//Описание структуры данных
//Сущность "геометрическая фигура" содержит следующие поля:

//Длина стороны (float): может быть положительным или отрицательным значением.
//Количество сторон (int): может быть положительным или отрицательным числом.
//Цвет (enum): возможные значения перечисления: RED, BLUE, GREEN, YELLOW, BLACK, WHITE.
//Некоторые геометрические фигуры могут быть физически невозможными (например, с отрицательной длиной стороны
// или отрицательным количеством сторон). Также фигуры с 1 или 2 сторонами являются допустимыми и представляют собой линию,
// у которой отсутствуют углы.

//Требуемые матчеры
//Проверка длины стороны в заданном диапазоне (например, от 0.1 до 100.0).
//Проверка количества углов:
//Для фигур с 3 и более сторонами количество углов совпадает с количеством сторон.
//Для фигур с 1 или 2 сторонами (линий) углы отсутствуют (значение углов = 0).
//Проверка на чётное количество сторон.
//Проверка цвета фигуры.
//Проверка на наличие отрицательной длины стороны (недопустимо).
//Проверка на наличие отрицательного количества сторон (недопустимо).
//Дополнительные условия
//Для реализации матчеров используйте наследование от TypeSafeDiagnosingMatcher<T>.

//Все проверки должны быть логически корректными и учитывать особенности фигур (например, линии не должны проверяться
// на количество углов).

//Протестируйте работу матчеров на 20 различных фигурах, включая:

//Корректные фигуры (например, треугольник, квадрат, линия и т. д.).
//Фигуры с 1 и 2 сторонами (линии).
//Некорректные фигуры с отрицательными значениями количества сторон или длины стороны.
//Ниже enum с цветом и набор тестовых данных, на которых можно проверить работу ассертов через assertThat и
// фильтров по набору матчеров, объединённых в allOf или anyOf

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

val shapes = listOf(
    Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
)

data class Shape(
    val length: Float,
    val numberOfSide: Int,
    val color: Color
)

//Проверка длины стороны в заданном диапазоне (например, от 0.1 до 100.0).
class SideLengthInAGivenRangeFrom(
    private val expectedSideRangeFrom: Float,
    private val expectedSideRangeTo: Float
) : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.length !in expectedSideRangeFrom..expectedSideRangeTo) {
            mismatchDescription.appendValue("not in range")
                .appendValue(item.length)
            return false
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("side in range from")
            .appendValue(expectedSideRangeFrom..expectedSideRangeTo)
    }
}

//Проверка количества углов:
//Для фигур с 3 и более сторонами количество углов совпадает с количеством сторон.
//Для фигур с 1 или 2 сторонами (линий) углы отсутствуют (значение углов = 0).
class CheckingTheNumberOfCorners(val cornerNumber: Int) : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.numberOfSide > 3) {
            cornerNumber == item.numberOfSide
            return true
        } else if (item.numberOfSide == 1 || item.numberOfSide == 2) {
            cornerNumber == 0
            return true
        } else
            mismatchDescription.appendText("the side can't be <= 0")
                .appendValue(item.numberOfSide)
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("Number of corners")
            .appendValue(cornerNumber)
    }

}

//Проверка на чётное количество сторон.
class EvenNumbersOfSides : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.numberOfSide % 2 != 0) {
            mismatchDescription.appendText("not even number of side")
            return false
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("even number of side")
    }
}


//Проверка цвета фигуры.
class CheckingColor(
    private val expectedColor: Color
) : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.color != expectedColor) {
            mismatchDescription.appendText("color was ")
                .appendValue(item.color)
            return false
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("color is")
            .appendValue(expectedColor.name)
    }

}

//Проверка на наличие отрицательной длины стороны (недопустимо).
class CheckingNegativeLengthSide : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        item.length.also {
            if (it < 0) {
                mismatchDescription.appendText("the side doesn't have negative value")
                return false
            }
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText(" the side has negative value")
    }
}


//Проверка на наличие отрицательного количества сторон (недопустимо).

class CheckNegativeQualityOfSides : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        item.numberOfSide.also {
            if (it < 0) {
                mismatchDescription.appendText("the side doesn't have negative value")
                return false
            }
            return true
        }
    }

    override fun describeTo(description: Description) {
        description.appendText(" the quality sides have negative value")
    }
}

fun main() {

    //expected
    fun isRange(expectedSideRangeFrom: Float, expectedSideRangeTo: Float) =
        SideLengthInAGivenRangeFrom(expectedSideRangeFrom, expectedSideRangeTo)

    fun expectedCorners(cornerNumber: Int) = CheckingTheNumberOfCorners(cornerNumber)
    fun even() = EvenNumbersOfSides()
    fun expectedColor(expectedColor: Color) = CheckingColor(expectedColor)
    fun negativeSide() = CheckingNegativeLengthSide()
    fun negativeQualityOfSide() = CheckNegativeQualityOfSides()

// Фильтрация с использованием allOf
    val filteredShapes = shapes.filter { shape ->
        allOf(
            isRange(1F, 100F),
            expectedColor(Color.RED),
            even(),
            negativeSide(),
            negativeQualityOfSide(),
            expectedCorners(6)
        ).matches(shape)
    }

    // Примеры ассертов
    fun testMatchers() {
        val shape = Shape(10f, 4, Color.RED)
        assertThat(shape, isRange(1f, 20f))
        assertThat(shape, expectedColor(Color.RED))
        assertThat(shape, negativeSide())
        assertThat(shape, negativeQualityOfSide())
        assertThat(shape, expectedCorners(6))
    }
    testMatchers()
    println("$filteredShapes")

}
