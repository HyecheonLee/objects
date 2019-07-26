import java.lang.IllegalStateException
import java.time.Duration

class Movie {
    private lateinit var title: String
    private lateinit var runningTime: Duration
    private lateinit var fee: Money
    private lateinit var discountCondition: List<DiscountCondition>

    private lateinit var movieType: MovieType
    private lateinit var discountAmount: Money
    private var discountPercent: Double = 0.0

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) fee.minus(calculateDiscountAmount()) else fee
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()

        }
    }


    private fun calculateNoneDiscountAmount(): Money = Money.ZERO

    private fun calculatePercentDiscountAmount(): Money = fee.times(discountPercent)

    private fun calculateAmountDiscountAmount(): Money = discountAmount

    private fun isDiscountable(screening: Screening): Boolean = discountCondition.any { it.isSatisfiedBy(screening) }
}
