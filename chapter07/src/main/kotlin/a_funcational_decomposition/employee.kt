package a_funcational_decomposition

import java.util.*

val employees = listOf("직원A", "직원B", "직원C")
val basePays = listOf(400, 300, 250)
fun main(args: Array<String>) {
    start("직원AK")
}

fun start(name: String) {
    val taxRate = getTaxRate()
    val pay = calculatePayFor(name, taxRate)
    print(describeResult(name, pay));
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
