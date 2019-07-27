data class Bag(var amount: Long,
               val invitation: Invitation,
               var ticket: Ticket) {
    fun hasInvitation(): Boolean {
        return true
    }

    fun minusAmount(fee: Long) {
        this.amount -= fee
    }
}
