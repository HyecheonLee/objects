import java.time.DayOfWeek
import java.time.LocalTime

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}

class SequenceCondition(private val sequence: Int) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}

class PeriodCondition(private val dayOfWeek: DayOfWeek, private val startTime: LocalTime, private val endTime: LocalTime) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return (screening.getStartTime().dayOfWeek == dayOfWeek) and
                (startTime <= screening.getStartTime().toLocalTime()) and
                (endTime >= screening.getStartTime().toLocalTime())
    }
}
