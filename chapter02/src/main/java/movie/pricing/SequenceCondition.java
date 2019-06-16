package movie.pricing;

import movie.DisCountCondition;
import movie.Screening;

public class SequenceCondition implements DisCountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}