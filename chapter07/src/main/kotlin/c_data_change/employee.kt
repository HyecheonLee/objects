package c_data_change

import java.util.*

val employees = listOf("직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F")
val basePays: List<Double> = listOf(400.toDouble(), 300.toDouble(), 250.toDouble(), 1.toDouble(), 1.toDouble(), 1.5)
val hourlys = listOf(false, false, false, true, true, true)
val timeCards = listOf(0, 0, 0, 120, 120, 120)
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
    val pay = if (isHourly(name)) {
        calculateHourlyPayFor(name, taxRate)
    } else {
        calculatePayFor(name, taxRate)
    }
    print(describeResult(name, pay));
}

fun sumOfBasePays() {
    val result = employees
            .filter { name -> !isHourly(name) }
            .map { name -> basePays[employees.indexOf(name)] }
            .sum()

    print(result)
}


fun describeResult(name: String, pay: Double): String {
    return "이름 $name, 급여:$pay"
}

fun calculatePayFor(name: String, taxRate: Double): Double {
    val index = employees.indexOf(name)
    val basePay = basePays[index]
    return basePay - (basePay * taxRate)
}

fun getTaxRate(): Double {
    val sc = Scanner(System.`in`)
    print("세율을 입력하세요: ")
    return sc.nextDouble()
}

fun calculateHourlyPayFor(name: String, taxRate: Double): Double {
    val index = employees.indexOf(name)
    val basePay = basePays[index] * timeCards[index]
    return basePay - (basePay * taxRate)
}

fun isHourly(name: String): Boolean {
    return hourlys[employees.indexOf(name)]
}