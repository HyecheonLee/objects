package billing.step04

import Money
import java.time.Duration

open class Phone(public val amount: Money, private val seconds: Duration, private val calls: ArrayList<Call> = ArrayList()) {
    fun call(call: Call) {
        calls.add(call)
    }

    open fun calculateFee() =
            calls.fold(Money.ZERO) { money, call -> money.plus(amount.times(call.getDuration().seconds / seconds.seconds)) }

}