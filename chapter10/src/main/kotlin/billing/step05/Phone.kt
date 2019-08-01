package billing.step05

import Money
import java.time.Duration

open class Phone(val amount: Money, private val seconds: Duration, open val taxRate: Double, private val calls: ArrayList<Call> = ArrayList()) {
    fun call(call: Call) {
        calls.add(call)
    }

    open fun calculateFee(): Money {
        val result = calls.fold(Money.ZERO) { money, call -> money.plus(amount.times(call.getDuration().seconds / seconds.seconds)) }
        return result.plus(result.times(taxRate))
    }
}