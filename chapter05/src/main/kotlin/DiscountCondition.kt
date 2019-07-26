import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(
        private var type: DiscountConditionType,
        private val sequence: Int,
        private val dayOfWeek: DayOfWeek,
        private val startTime: LocalTime,
        private val endTime: LocalTime
) {
    fun isDiscountable(screening: Screening): Boolean =
            if (type === DiscountConditionType.PERIOD) {
                isSatisfiedByPeriod(screening)
            } else isSatisfiedBySequence(screening)


    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return screening.whenScreened.dayOfWeek == dayOfWeek &&
                startTime <= screening.whenScreened.toLocalTime() &&
                endTime >= screening.whenScreened.toLocalTime()
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}