/**
 * Joel Amoakoh!
 * 20096482
 */
package ie.setu

import controllers.EmployeeAPI
import models.employee
import mu.KotlinLogging
import kotlin.math.round
import java.time.LocalDate


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
                5 -> update()
                6 -> delete()
                7 -> attendance()
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
         |   5. Update Employee
         |   6. Delete Employee
         |   7. Clock In
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
fun update() {
    val employeeToUpdate = getEmployeeById()
    if (employeeToUpdate != null) {
        print("Enter new first name: ")
        val newFirstName = readLine().toString()
        print("Enter new surname: ")
        val newSurname = readLine().toString()
        print("Enter new gender (m/f): ")
        val newGender = readLine()!!.toCharArray()[0]
        print("Enter new gross salary: ")
        val newGrossSalary = readLine()!!.toDouble()
        print("Enter new PAYE %: ")
        val newPayePercentage = readLine()!!.toDouble()
        print("Enter new PRSI %: ")
        val newPrsiPercentage = readLine()!!.toDouble()
        print("Enter new Annual Bonus: ")
        val newAnnualBonus = readLine()!!.toDouble()
        print("Enter new Cycle to Work Deduction: ")
        val newCycleToWorkMonthlyDeduction = readLine()!!.toDouble()

        employees.update(employeeToUpdate.employeeID, employee(newFirstName, newSurname, newGender, 0, newGrossSalary, newPayePercentage, newPrsiPercentage, newAnnualBonus, newCycleToWorkMonthlyDeduction))
    }


}
fun delete(){
        val employee = getEmployeeById()
        if (employee != null) {
            employees.delete(employee.employeeID)
            println("Employee with id ${employee.employeeID} is deleted")
        } else {
            println("No employee found")
        }
    }
fun attendance(){
    println("You have clocked in :" + LocalDate.now())
}



