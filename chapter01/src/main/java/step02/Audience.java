package step02;

import lombok.Data;

@Data
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
