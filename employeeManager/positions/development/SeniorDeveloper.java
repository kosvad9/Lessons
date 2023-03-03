package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class SeniorDeveloper extends Position {
    public SeniorDeveloper() {
        super("Senior разработчик", Department.DEVELOPMENT, new BigDecimal(1800), new BigDecimal(4000));
    }
}
