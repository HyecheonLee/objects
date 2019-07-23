import java.time.Duration

data class Movie(var title: String,
                 var duration: Duration,
                 var fee: Money,
                 var discountConditions: List<DiscountCondition>,
                 var movieType: MovieType,
                 var discountAmount: Money,
                 var discountPercent: Double) {
}