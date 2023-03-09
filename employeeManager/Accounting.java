package employeeManager;

import java.math.BigDecimal;

public class Accounting {
    public static void changeSalary(Employee employee, BigDecimal newSalary){
//        if (newSalary.compareTo(employee.getPosition().getMinSalary()) >= 0 &&
//                newSalary.compareTo(employee.getPosition().getMaxSalary()) <= 0)
        employee.setSalary(newSalary);
//        else System.out.printf("Для работника \'%s %s\' указанная ЗП вне диапазона выбранной должности!",employee.getFirstName(),employee.getLastName());
    }
}
