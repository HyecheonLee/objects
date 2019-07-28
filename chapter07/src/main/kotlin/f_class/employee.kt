package f_class

import c_data_change.calculateHourlyPayFor
import java.util.*

abstract class Employee(val name: String, val basePay: Long) {
    abstract fun calculatePay(taxRate: Double): Double
    abstract fun monthlyBasePay(): Double
}

class SalariedEmployee(name: String, basePay: Long) : Employee(name, basePay) {
    override fun calculatePay(taxRate: Double): Double = basePay - (basePay * taxRate)
    override fun monthlyBasePay(): Double = basePay.toDouble()
}

class HourlyEmployee(name: String, basePay: Long, private val timeCard: Int) : Employee(name, basePay) {
    override fun calculatePay(taxRate: Double): Double = (basePay * timeCard) - (basePay * timeCard) * taxRate
    override fun monthlyBasePay(): Double = 0.toDouble()
}

val employees = listOf(
        SalariedEmployee("직원A", 400),
        SalariedEmployee("직원B", 300),
        SalariedEmployee("직원C", 250),
        HourlyEmployee("아르바이트D", 1, 120),
        HourlyEmployee("아르바이트E", 1, 120),
        HourlyEmployee("아르바이트F", 1, 120)
)

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

