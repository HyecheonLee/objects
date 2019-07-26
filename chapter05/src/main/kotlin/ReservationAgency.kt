class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val discountable = checkDiscountable(screening)
        val fee = calculateFee(screening, discountable, audienceCount)
        return createReservation(screening, customer, audienceCount, fee)
    }

    private fun checkDiscountable(screening: Screening): Boolean {
        return screening.movie.discountConditions.any { condition ->
            condition.isDiscountable(screening)
        }
    }

    private fun calculateFee(screening: Screening, discountable: Boolean, audienceCount: Int): Money {
        return if (discountable) {
            screening.movie.fee.minus(calculateDiscountedFee(screening.movie))
                    .times(audienceCount)
        } else {
            screening.movie.fee
        }
    }

    private fun calculateDiscountedFee(movie: Movie): Money {
        return when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie)
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountedFee(movie)
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountedFee(movie)
        }
    }

    private fun calculateNoneDiscountedFee(movie: Movie) = movie.fee
    private fun calculatePercentDiscountedFee(movie: Movie) = movie.fee.times(movie.discountPercent)
    private fun calculateAmountDiscountedFee(movie: Movie) = movie.discountAmount
    private fun createReservation(screening: Screening, customer: Customer, audienceCount: Int, fee: Money): Reservation =
            Reservation(customer, screening, fee, audienceCount)
}