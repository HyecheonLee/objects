package movie

import Money
import Screening
import discount_condition.DiscountCondition
import java.time.Duration

class AmountDiscountMovie(title: String, runningTime: Duration, fee: Money, private val discountAmount: Money,
                          vararg discountConditions: DiscountCondition) : Movie(title, runningTime, fee, *discountConditions) {

    protected override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}