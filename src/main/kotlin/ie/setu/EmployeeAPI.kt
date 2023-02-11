/**
 * Joel Amoakoh!
 * 20096482
 */
package ie.setu

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

}
