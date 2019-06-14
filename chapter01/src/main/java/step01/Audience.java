package step01;

import lombok.Data;

@Data
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }
}
