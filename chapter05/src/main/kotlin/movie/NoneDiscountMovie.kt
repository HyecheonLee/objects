package movie

import Money
import Screening
import discount_condition.DiscountCondition
import java.time.Duration

class NoneDiscountMovie(title: String,
                        runningTime: Duration,
                        fee: Money,
                        vararg discountConditions: DiscountCondition) :
        Movie(title, runningTime, fee, *discountConditions) {
    override fun calculateDiscountAmount(): Money = Money.ZERO
}