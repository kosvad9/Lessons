package employeeManager;

import java.math.BigDecimal;

public interface Position {
    public String getName();
    public Department getDepartment();
    public BigDecimal getMinSalary();
    public BigDecimal getMaxSalary();
}
