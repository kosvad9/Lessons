package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

public class HeadOfHR extends AbstractPosition {
    public HeadOfHR() {
        super("Главный HR", Department.HR, new BigDecimal(800), new BigDecimal(1700));
    }
}
