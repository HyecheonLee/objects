package ex01

data class Bag(var amount: Long,
               val invitation: Invitation,
               private var ticket: Ticket) {
    fun hold(ticket: Ticket): Long {
        return if (hasInvitation()) {
            this.ticket = ticket
            0L
        } else {
            this.ticket = ticket
            minusAmount(ticket.fee)
            ticket.fee
        }
    }

    private fun hasInvitation(): Boolean {
        return true
    }

    private fun minusAmount(fee: Long) {
        this.amount -= fee
    }

}
