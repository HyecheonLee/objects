package billing.step01

import Money
import java.time.Duration
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val phone = Phone(Money.wons(5), Duration.ofSeconds(10))
    phone.call(Call(
            LocalDateTime.of(2018, 1, 1, 12, 10, 0),
            LocalDateTime.of(2018, 1, 1, 12, 11, 0)
    ))
    phone.call(Call(
            LocalDateTime.of(2018, 1, 1, 12, 10, 0),
            LocalDateTime.of(2018, 1, 1, 12, 11, 0)
    ))

    print(phone.calculateFee())

}