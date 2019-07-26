package movie

import Money
import discount_condition.DiscountCondition
import java.time.Duration
import java.util.Arrays


class PercentDiscountMovie(title: String, runningTime: Duration, fee: Money, private val percent: Double,
                           vararg discountConditions: DiscountCondition) : Movie(title, runningTime, fee, *discountConditions) {

    protected override fun calculateDiscountAmount(): Money {
        return fee.times(percent)
    }
}