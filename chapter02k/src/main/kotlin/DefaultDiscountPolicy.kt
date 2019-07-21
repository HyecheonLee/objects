interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}

abstract class DefaultDiscountPolicy(vararg conditions: DiscountCondition) : DiscountPolicy {
    private val conditions: List<DiscountCondition> = listOf(*conditions)

    override fun calculateDiscountAmount(screening: Screening): Money {
        return if (conditions.any { it.isSatisfiedBy(screening) }) getDiscountAmount(screening) else Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}

class AmountDiscountPolicy(private val discountAmount: Money, vararg conditions: DiscountCondition) : DefaultDiscountPolicy(*conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }

}

class PercentDiscountPolicy(private val percent: Double, vararg conditions: DiscountCondition) : DefaultDiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}

class NoneDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}