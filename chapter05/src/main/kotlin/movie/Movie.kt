package movie

import Money
import Screening
import discount_condition.DiscountCondition
import java.time.Duration
import java.util.*

abstract class Movie(public val title: String,
                     public val runningTime: Duration,
                     public val fee: Money,
                     vararg discountConditions: DiscountCondition) {
    public val discountConditions: List<DiscountCondition> = listOf(*discountConditions)

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) {
            fee.minus(calculateDiscountAmount())
        } else fee

    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { condition -> condition.isSatisfiedBy(screening) }
    }

    protected abstract fun calculateDiscountAmount(): Money
}