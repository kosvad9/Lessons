package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class MiddleDeveloper extends Position {
    public MiddleDeveloper() {
        super("Middle разработчик", Department.DEVELOPMENT, new BigDecimal(800), new BigDecimal(2000));
    }
}
