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
        return String.format("%-10s %-10s, id: %-3s, \tОтдел: %-20s, \tДолжность: %-20s, \tЗП: %-6s, \tДата устройства: %-10s", lastName,firstName, id, position.getDepartment(), position.getName(), salary, dateOfEmployment);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.salary = position.getMinSalary();
    }

    public void setSalary(BigDecimal newSalary){
        salary = newSalary;
        salaryRevisionDate = LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
