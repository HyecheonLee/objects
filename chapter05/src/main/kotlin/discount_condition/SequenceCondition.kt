package discount_condition

import Screening

data class SequenceCondition(val sequence: Int) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean = sequence == screening.sequence
}