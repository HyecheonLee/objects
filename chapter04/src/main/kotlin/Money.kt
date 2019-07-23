import java.math.BigDecimal

class Money internal constructor(private val amount: BigDecimal) {

    operator fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    operator fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    operator fun times(percent: Int): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent.toLong())))
    }

    fun isLessThan(other: Money): Boolean {
        return amount.compareTo(other.amount) < 0
    }


    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount.compareTo(other.amount) >= 0
    }

    companion object {

        val ZERO = Money.wons(0)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}