package ex02

import java.time.Duration
import java.time.LocalDateTime

data class Event(val subject: String, val from: LocalDateTime, var duration: Duration) {
    fun isSatisfied(schedule: RecurringSchedule): Boolean {
        return if (from.dayOfWeek != schedule.dayOfWeek ||
                from.toLocalTime() != schedule.from ||
                duration != schedule.duration
        ) {
            reschedule(schedule)
            false
        } else {
            true;
        }
    }

    private fun reschedule(schedule: RecurringSchedule) {
        LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.from)
        duration = schedule.duration
    }

    private fun daysDistance(schedule: RecurringSchedule): Long {
        return (schedule.dayOfWeek.value - from.dayOfWeek.value).toLong()
    }
}