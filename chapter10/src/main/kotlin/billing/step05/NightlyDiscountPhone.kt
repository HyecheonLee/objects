package billing.step05

import Money
import java.time.Duration

data class NightlyDiscountPhone(private val nightlyAmount: Money, private val regularAmount: Money, private val seconds: Duration, override val taxRate: Double, private val calls: ArrayList<Call> = ArrayList())
    : Phone(regularAmount, seconds, taxRate) {

    override fun calculateFee(): Money {
        val nightlyFee = calls.filter { call -> call.from.hour >= LATE_NIGHT_HOUR }.fold(Money.ZERO,
                { money,
                  call ->
                    money.plus(super.amount.minus(nightlyAmount).times(call.getDuration().seconds / seconds.seconds))
                }
        )
        return super.calculateFee().minus(nightlyFee.plus(nightlyFee.times(super.taxRate)))
    }

    companion object {
        private const val LATE_NIGHT_HOUR: Int = 22
    }
}

