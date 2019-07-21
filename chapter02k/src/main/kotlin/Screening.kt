import java.time.LocalDateTime

data class Screening(private val movie: Movie, private val sequence: Int, val whenScreened: LocalDateTime) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation =
            Reservation(customer, this, calculateFee(audienceCount), audienceCount)

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }

    fun isSequence(sequence: Int) = this.sequence == sequence
    fun getStartTime() = whenScreened
    fun getMovieFee(): Money {
        return movie.fee
    }
}