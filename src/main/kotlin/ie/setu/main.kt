/**
 * Joel Amoakoh!
 * 20096482
 */
package ie.setu

import mu.KotlinLogging
import kotlin.math.round

var Employee =  employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)
var employees = EmployeeAPI()
val logger = KotlinLogging.logger {}
fun main (args: Array<String>){
    logger.info { "Launching Employee App" }
    logger.info { "\tAssignment 1 2023!"}
    logger.info { "\t Made by Joel Amoakoh"}
    logger.info {" \t 20096482"}
    start()

}
    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> list()
                3 -> search()
                4 -> paySlip()
                -99 -> dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
    }

    fun menu(): Int {
        print(
            """ 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin()
        )
        return readLine()!!.toInt()
    }

    fun roundTwoDecimals(number: Double) = round(number * 100) / 100
fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}




fun list(){
    employees.findAll()
        .forEach{ println(it) }
}



internal fun getEmployeeById(): employee? {
        print("Enter the employee id to search by: ")
        val employeeID = readLine()!!.toInt()
        return employees.findOne(employeeID)
    }

    fun search() {
        val Employee = getEmployeeById()
        if (Employee == null)
            println("No employee found")
        else
            println(Employee)

    }

    fun paySlip() {
        val employee = getEmployeeById()
        if (employee != null)
            println(employee.getPayslip())
    }

    fun dummyData() {
        employees.create(employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
        employees.create(employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
        employees.create(employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
    }

