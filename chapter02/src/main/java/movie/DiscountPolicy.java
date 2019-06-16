package movie;

import money.Money;
import movie.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class DiscountPolicy {
    private List<DisCountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DisCountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        final Optional<Money> moneyOptional =
                conditions.stream()
                        .filter(condition -> condition.isSatisfiedBy(screening))
                        .map(disCountCondition -> getDiscountAmount(screening))
                        .findAny();
        return moneyOptional.orElse(Money.ZERO);
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
