package employeeManager;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee{
    private String firstName;
    private String lastName;
    private int id;
    private Position position;
    private LocalDate dateOfEmployment;
    private BigDecimal salary;
    private LocalDate salaryRevisionDate;

    public Employee(String firstName, String lastName, int id, Position position, LocalDate dateOfEmployment, BigDecimal salary, LocalDate salaryRevisionDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
        if (salary.compareTo(position.getMinSalary()) >= 0 && salary.compareTo(position.getMaxSalary()) <= 0)
            this.salary = salary;
        else
            throw new IllegalArgumentException(String.format("Для работника с id \'%s\' указанная ЗП вне диапазона выбранной должности!",id));
        this.salaryRevisionDate = salaryRevisionDate;
    }

    public Employee(String firstName, String lastName, int id, Position position, BigDecimal salary) {
        this(firstName,lastName,id,position,LocalDate.now(),salary,null);
    }

    @Override
    public String toString() {
        return String.format("(%s %s, %s, Отдел: %s, Должность: %s, ЗП: %s)", lastName,firstName, id, position.getDepartment(), position.getName(), salary);
    }
}
