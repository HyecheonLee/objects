import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition {
    lateinit var type: DiscountConditionType
    var sequence: Int = 0
    lateinit var dayOfWeek: DayOfWeek
    lateinit var startTime: LocalTime
    lateinit var endTime: LocalTime

    fun isSatisfiedBy(screening: Screening): Boolean {
        return if (type == DiscountConditionType.PERIOD) isSatisfiedByPeriod(screening) else isSatisfiedBySequence(screening)
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return (dayOfWeek == screening.whenScreened.dayOfWeek) and
                (startTime <= screening.whenScreened.toLocalTime()) and
                endTime.isAfter(screening.whenScreened.toLocalTime())
    }
}
