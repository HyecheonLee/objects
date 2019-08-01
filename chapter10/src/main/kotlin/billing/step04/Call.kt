package billing.step04

import java.time.Duration
import java.time.LocalDateTime

data class Call(val from: LocalDateTime, private val to: LocalDateTime) {
    fun getDuration(): Duration {
        return Duration.between(from, to)
    }
}
