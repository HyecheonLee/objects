import java.lang.IllegalArgumentException
import java.time.Duration
import java.time.LocalDateTime

data class Movie(var title: String,
                 var duration: Duration,
                 var fee: Money,
                 var discountConditions: List<DiscountCondition>,
                 var movieType: MovieType,
                 var discountAmount: Money,
                 var discountPercent: Double) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT)
            throw IllegalArgumentException()
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return discountConditions.any { condition ->
            if (condition.type == DiscountConditiontType.PERIOD) {
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())) {
                    return true
                }
            } else {
                if (condition.isDiscountable(sequence)) return true
            }
            return false
        }
    }
}