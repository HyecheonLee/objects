data class TicketSeller(val ticketOffice: TicketOffice) {
    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.ticket))
    }
}
