data class Bag(var amount: Long,
               val invitation: Invitation,
               private var ticket: Ticket) {
    fun setTicket(ticket: Ticket): Long {
        return if (hasInvitation()) {
            this.ticket = ticket
            0L
        } else {
            this.ticket = ticket
            minusAmount(ticket.fee)
            ticket.fee
        }
    }

    fun hasInvitation(): Boolean {
        return true
    }

    fun minusAmount(fee: Long) {
        this.amount -= fee
    }

}
