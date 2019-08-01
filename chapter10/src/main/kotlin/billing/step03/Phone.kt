package billing.step03

import Money
import java.time.Duration
import java.util.ArrayList


class Phone(private val type: PhoneType, private val amount: Money, private val nightlyAmount: Money,
            private val regularAmount: Money, private val seconds: Duration) {
    private val calls = ArrayList<Call>()

    enum class PhoneType {
        REGULAR, NIGHTLY
    }

    constructor(amount: Money, seconds: Duration) : this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds)
    constructor(nightlyAmount: Money, regularAmount: Money, seconds: Duration) :
            this(PhoneType.NIGHTLY, Money.ZERO, nightlyAmount, regularAmount, seconds)

    fun calculateFee(): Money {
        return if (type == PhoneType.REGULAR) {
            calls.fold(Money.ZERO) { money, call -> money.plus(amount.times(call.getDuration().seconds / seconds.seconds)) }
        } else {
            calls.fold(Money.ZERO,
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

    companion object {
        private const val LATE_NIGHT_HOUR = 22
    }
}