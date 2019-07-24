import java.lang.IllegalArgumentException
import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(val type: DiscountConditiontType,
                             val sequence: Int,
                             val dayOfWeek: DayOfWeek,
                             val startTime: LocalTime,
                             val endTime: LocalTime) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditiontType.PERIOD) {
            throw IllegalArgumentException()
        }
        return this.dayOfWeek == dayOfWeek && this.startTime <= time && this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditiontType.SEQUENCE) {
            throw IllegalArgumentException()
        }
        return this.sequence == sequence
    }
}

