data class TicketSeller(val ticketOffice: TicketOffice) {
    fun setTicket(audience: Audience) {
        ticketOffice.plusAmount(audience.setTicket(ticketOffice.ticket))
    }
}
