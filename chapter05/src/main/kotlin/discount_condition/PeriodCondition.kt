package discount_condition

import Screening
import java.time.DayOfWeek
import java.time.LocalTime

data class PeriodCondition(val dayOfWeek: DayOfWeek, val startTime: LocalTime, val endTime: LocalTime) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return (dayOfWeek == screening.whenScreened.dayOfWeek) and
                (startTime <= screening.whenScreened.toLocalTime()) and
                endTime.isAfter(screening.whenScreened.toLocalTime())
    }
}