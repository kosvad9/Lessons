package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

public class JuniorDeveloper extends AbstractPosition {
    public JuniorDeveloper() {
        super("Junior разработчик", Department.DEVELOPMENT, new BigDecimal(400), new BigDecimal(1000));
    }
}
