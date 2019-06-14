package step02;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
