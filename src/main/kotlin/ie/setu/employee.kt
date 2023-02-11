/**
 * Joel Amoakoh!
 * 20096482
 */
package ie.setu

class employee(var firstName: String, var surname: String, var gender: Char, var employeeID: Int, var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double, var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double) {

    fun getFullName() = when (Employee.gender) {
        'm', 'M' -> "Mr. ${Employee.firstName} ${Employee.surname}"
        'f', 'F' -> "Ms.  ${Employee.firstName} ${Employee.surname}"
        else -> "${Employee.firstName} ${Employee.surname}"
    }

    fun getMonthlySalary() = roundTwoDecimals(Employee.grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (Employee.prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (Employee.payePercentage / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (Employee.annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + Employee.cycleToWorkMonthlyDeduction))
    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

    fun getPayslip() =
        """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullName()}, ID: ${Employee.employeeID}                 
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(Employee.annualBonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work: ${Employee.cycleToWorkMonthlyDeduction}         
        ______________________________________________________________________
             NET PAY: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""

    override fun toString(): String {
        return "employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }

}


