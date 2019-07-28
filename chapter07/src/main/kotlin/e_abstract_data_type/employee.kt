package e_abstract_data_type

import c_data_change.calculateHourlyPayFor
import java.util.*

data class Employee(val name: String, val basePay: Long, val hourly: Boolean, val timeCard: Int) {
    fun calculatePay(taxRate: Double): Double {
        return if (hourly) {
            calculateHourlyPayFor(taxRate)
        } else {
            calculateSalariedPay(taxRate)
        }
    }

    fun monthlyBasePay(): Long {
        return if (hourly) 0.toLong() else basePay
    }

    private fun calculateHourlyPayFor(taxRate: Double): Double {
        return (basePay * timeCard) - (basePay * timeCard) * taxRate
    }

    private fun calculateSalariedPay(taxRate: Double): Double {
        return basePay - (basePay * taxRate)
    }
}

val employees = listOf(
        Employee("직원A", 400, false, 0),
        Employee("직원B", 300, false, 0),
        Employee("직원C", 250, false, 0),
        Employee("아르바이트D", 1, true, 120),
        Employee("아르바이트E", 1, true, 120),
        Employee("아르바이트F", 1, true, 120))
//private val basePays: List<Double> = listOf(400.toDouble(), 300.toDouble(), 250.toDouble(), 1.toDouble(), 1.toDouble(), 1.5)
//private val hourlys = listOf(false, false, false, true, true, true)
//private val timeCards = listOf(0, 0, 0, 120, 120, 120)

fun main(args: Array<String>) {
    start("pay", "직원A")
    start("basePays")
}

fun start(operation: String,
          name: String = "") {
    when (operation) {
        "pay" -> calculatePay(name)
        "basePays" -> sumOfBasePays()
    }
}

fun calculatePay(name: String) {
    val taxRate = getTaxRate()
    val employee = employees.find { employee -> employee.name == name }
    val pay = employee?.calculatePay(taxRate)
    pay?.let { print(describeResult(name, pay)) }
}

fun sumOfBasePays() {
    val result = employees.map { employee -> employee.monthlyBasePay() }
            .sum()
    print(result)
}


fun describeResult(name: String, pay: Double): String {
    return "이름 $name, 급여:$pay"
}


fun getTaxRate(): Double {
    val sc = Scanner(System.`in`)
    print("세율을 입력하세요: ")
    return sc.nextDouble()
}

