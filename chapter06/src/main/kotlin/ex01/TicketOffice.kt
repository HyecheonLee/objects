package ex01

import java.util.*

class TicketOffice(private var amount: Long, vararg tickets: Ticket) {
    private val tickets = ArrayList<Ticket>()

    val ticket: Ticket
        get() = tickets.removeAt(0)

    init {
        this.tickets.addAll(listOf(*tickets))
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(sell: Long) {
        this.amount += amount
    }
}