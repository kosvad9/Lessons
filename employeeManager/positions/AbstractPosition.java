package employeeManager.positions;

import employeeManager.Department;
import employeeManager.Position;

import java.math.BigDecimal;

public abstract class AbstractPosition implements Position {
    final protected String name;
    final protected Department department;
    final protected BigDecimal minSalary;
    final protected BigDecimal maxSalary;

    protected AbstractPosition(String name, Department department, BigDecimal minSalary, BigDecimal maxSalary){
        this.name = name;
        this.department = department;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    @Override
    public BigDecimal getMinSalary() {
        return minSalary;
    }

    @Override
    public BigDecimal getMaxSalary() {
        return maxSalary;
    }
}
