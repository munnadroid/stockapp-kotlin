package com.awecode.stockapp.util

/**
 * Created by munnadroid on 6/8/17.
 */

class CalculationUtil {
    companion object {
        fun brokerCommission(totalAmount: Double): Double {
            var commissionPercent: Double = 0.0

            if (totalAmount <= 50000)
                commissionPercent = 0.60
            else if (totalAmount in 50001..500000)
                commissionPercent = 0.55
            else if (totalAmount in 500001..2000000)
                commissionPercent = 0.50
            else if (totalAmount in 2000001..10000000)
                commissionPercent = 0.45
            else if (totalAmount > 10000001)
                commissionPercent = 0.40

            return (totalAmount * commissionPercent) / 100
        }

        fun sebonFee(totalAmount: Double): Double {
            return (totalAmount * 0.015) / 100
        }
    }
}