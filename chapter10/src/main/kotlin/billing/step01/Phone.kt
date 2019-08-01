package billing.step01

import Money
import java.time.Duration

class Phone(private val amount: Money, private val seconds: Duration, private val calls: ArrayList<Call> = ArrayList()) {
    fun call(call: Call) {
        calls.add(call)
    }

    fun calculateFee() =
            calls.fold(Money.ZERO) { money, call -> money.plus(amount.times(call.getDuration().seconds / seconds.seconds)) }
}