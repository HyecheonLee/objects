package billing.step01

import Money
import java.time.Duration

data class NightlyDiscountPhone(private val nightlyAmount: Money, private val regularAmount: Money, private val seconds: Duration, private val calls: ArrayList<Call> = ArrayList()) {
    private val LATE_NIGHT_HOUR: Int = 22

    fun calculateFee(): Money {
        return calls.fold(Money.ZERO,
                fun(money: Money, call: Call): Money {
                    return if (call.from.hour >= LATE_NIGHT_HOUR) {
                        money.plus(nightlyAmount.times(call.getDuration().seconds / seconds.seconds))
                    } else {
                        money.plus(regularAmount.times(call.getDuration().seconds / seconds.seconds))
                    }
                }
        )
    }
}

