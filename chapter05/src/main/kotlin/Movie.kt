import java.time.Duration
import java.util.Collections

data class Movie(private val title: String,
                 private val runningTime: Duration,
                 val fee: Money,
                 val discountConditions: List<DiscountCondition>,
                 val discountPercent: Double = 0.toDouble(),
                 val movieType: MovieType,
                 val discountAmount: Money) {
    fun calculateMovieFee(screening: Screening): Money {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}