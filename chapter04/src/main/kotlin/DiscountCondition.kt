import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(val type: DiscountConditiontType,
                             val sequence: Int,
                             val dayOfWeek: DayOfWeek,
                             val startTime: LocalTime,
                             val endTime: LocalTime)

