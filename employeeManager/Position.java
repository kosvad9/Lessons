package employeeManager;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Position extends Serializable {
    String getName();
    Department getDepartment();
    BigDecimal getMinSalary();
    BigDecimal getMaxSalary();
}
