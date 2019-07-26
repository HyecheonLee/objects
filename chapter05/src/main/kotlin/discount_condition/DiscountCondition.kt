package discount_condition

import Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
