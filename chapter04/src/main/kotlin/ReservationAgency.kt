class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie: Movie = screening.movie
//        var discountable = false
        /*for (condition in movie.discountConditions) {
            discountable = if (condition.type == DiscountConditiontType.PERIOD) {
                (screening.whenScreened.dayOfWeek == condition.dayOfWeek) and
                        (condition.startTime <= screening.whenScreened.toLocalTime()) and
                        (condition.endTime >= screening.whenScreened.toLocalTime())
            } else {
                condition.sequence == screening.sequence
            }
            if (discountable) {
                break
            }
        }*/

        val discountable = movie.discountConditions.any { condition ->
            if (condition.type == DiscountConditiontType.PERIOD) {
                (screening.whenScreened.dayOfWeek == condition.dayOfWeek) and
                        (condition.startTime <= screening.whenScreened.toLocalTime()) and
                        (condition.endTime >= screening.whenScreened.toLocalTime())
            } else {
                condition.sequence == screening.sequence
            }
        }

        val fee: Money = if (discountable) {
            val discountAmount = when (movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
                MovieType.PERCENT_DISCOUNT -> movie.fee.times(movie.discountPercent)
                MovieType.NONE_DISCOUNT -> Money.ZERO
            }
            movie.fee.minus(discountAmount).times(audienceCount)
        } else {
            movie.fee
        }
        return Reservation(customer, screening, fee, audienceCount)
    }

    fun reserve2(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}