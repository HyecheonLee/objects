data class Audience(var bag: Bag) {
    fun setTicket(ticket: Ticket): Long {
        return bag.setTicket(ticket)
    }
}
