/**
 * Joel Amoakoh!
 * 20096482
 */
package controllers

import models.employee


var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<employee>()

    fun findAll(): List<employee> {
        return employees
    }

    fun findOne(id: Int): employee? {
        return employees.find { p -> p.employeeID == id }
    }

    fun create(employee: employee) {
        employee.employeeID = getId()
        employees.add(employee)
    }

    fun update(id: Int, newEmployee: employee) {
        val foundEmployee = employees.find { it.employeeID == id }
        if (foundEmployee != null) {
            foundEmployee.firstName = newEmployee.firstName
            foundEmployee.surname = newEmployee.surname
            foundEmployee.gender = newEmployee.gender
            foundEmployee.grossSalary = newEmployee.grossSalary
            foundEmployee.payePercentage = newEmployee.payePercentage
            foundEmployee.prsiPercentage = newEmployee.prsiPercentage
            foundEmployee.annualBonus = newEmployee.annualBonus
            foundEmployee.cycleToWorkMonthlyDeduction = newEmployee.cycleToWorkMonthlyDeduction
        }
    }

    fun delete(id: Int): employee? {
        val foundEmployeeIndex = employees.indexOfFirst { it.employeeID == id }

        if (foundEmployeeIndex == -1) {
            return null
        } else {
            return employees.removeAt(foundEmployeeIndex)
        }
    }
}

