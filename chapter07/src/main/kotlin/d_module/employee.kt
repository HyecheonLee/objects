package d_module

import java.util.*

object Employees {
    private val employees = listOf("직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F")
    private val basePays: List<Double> = listOf(400.toDouble(), 300.toDouble(), 250.toDouble(), 1.toDouble(), 1.toDouble(), 1.5)
    private val hourlys = listOf(false, false, false, true, true, true)
    private val timeCards = listOf(0, 0, 0, 120, 120, 120)

    fun calculatePay(name: String, taxRate: Double): Double {
        return if (isHourly(name)) {
            calculateHourlyPayFor(name, taxRate)
        } else {
            calculatePayFor(name, taxRate)
        }
    }
    fun sumOfBasePays(): Double {
        return employees
                .filter { name -> !isHourly(name) }
                .map { name -> basePays[employees.indexOf(name)] }
                .sum()


    }
    private fun isHourly(name: String): Boolean {
        return hourlys[employees.indexOf(name)]
    }
    private fun calculateHourlyPayFor(name: String, taxRate: Double): Double {
        val index = employees.indexOf(name)
        val basePay = basePays[index] * timeCards[index]
        return basePay - (basePay * taxRate)
    }
    private fun calculatePayFor(name: String, taxRate: Double): Double {
        val index = employees.indexOf(name)
        val basePay = basePays[index]
        return basePay - (basePay * taxRate)
    }
}

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
    val pay = Employees.calculatePay(name, taxRate)
    print(describeResult(name, pay))
}

fun sumOfBasePays() {
    print(Employees.sumOfBasePays())
}


fun describeResult(name: String, pay: Double): String {
    return "이름 $name, 급여:$pay"
}


fun getTaxRate(): Double {
    val sc = Scanner(System.`in`)
    print("세율을 입력하세요: ")
    return sc.nextDouble()
}

