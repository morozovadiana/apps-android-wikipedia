package org.homework.lesson05

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    operator fun invoke(fnc: Schedule.() -> Unit) {
        fnc()
    }

    //
//    fun addShedule(day: Days, scheduleEntity: ScheduleEntity) {
//        addShedule(day, scheduleEntity)
//    }
//
    var dayweek: Days? = null
    fun monday(fnc: () -> Unit) = Days.MONDAY
    fun tuesday(fnc: () -> Unit) = Days.TUESDAY
    fun wednesday(fnc: () -> Unit) = Days.WEDNESDAY
    fun thursday(fnc: () -> Unit) = Days.THURSDAY
    fun friday(fnc: () -> Unit) = Days.FRIDAY
    fun saturday(fnc: () -> Unit) = Days.SATURDAY
    fun sunday(fnc: () -> Unit) = Days.SUNDAY


//    operator fun String.rangeTo(time: ScheduleEntity) : Pair<LocalTime, LocalTime> {
//        return time.startTime to time.endTime
//    }

    operator fun String.rangeTo(time: String): Pair<LocalTime, LocalTime> {
        return LocalTime.parse(this, timeFormatter) to
                LocalTime.parse(time, timeFormatter)
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(name: String) {
        addSchedule(
            dayweek ?: throw IllegalStateException(),
            ScheduleEntity(name, first, second)
        )
        dayweek = null
    }
}


fun main() {

    val schedule = Schedule()

    // Так добавляется расписание без DSL
    schedule.addSchedule(
        Days.MONDAY,
        ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10))
    )
    schedule.addSchedule(
        Days.MONDAY,
        ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55))
    )

    // Так добавляется расписание с использованием DSL
    schedule {

        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
    }

    println(schedule.toString())
}