import java.time.LocalDateTime

data class Screening(val movie: Movie, val sequence: Int, val whenScreened: LocalDateTime) {
    fun calculateFee(audienceCount: Int): Money {
        return when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT  -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    movie.calculateAmountDiscountedFee().times(audienceCount)
                } else {
                    movie.calculateNoneDiscountedFee().times(audienceCount)
                }
            }
            MovieType.PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    movie.calculatePercentDiscountedFee().times(audienceCount)
                } else {
                    movie.calculateNoneDiscountedFee().times(audienceCount)
                }
            }
            MovieType.NONE_DISCOUNT -> movie.calculateNoneDiscountedFee().times(audienceCount)
        }
    }
}