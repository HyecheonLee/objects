package step01;

import lombok.Data;

@Data
public class Bag {
    private Long amount;
    private Inviation inviation;
    private Ticket ticket;

    public Bag(Long amount) {
        this(null, amount);
    }

    public Bag(Inviation inviation, long amount) {
        this.inviation = inviation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return inviation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void minuAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
