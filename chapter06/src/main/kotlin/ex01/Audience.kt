package ex01

data class Audience(var bag: Bag) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
