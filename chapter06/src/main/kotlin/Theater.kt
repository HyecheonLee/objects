class Theater(private val ticketSeller: TicketSeller) {
    fun enter(audience: Audience) {
        ticketSeller.setTicket(audience)
    }
}