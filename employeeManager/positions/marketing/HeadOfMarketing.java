package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

public class HeadOfMarketing extends AbstractPosition {
    public HeadOfMarketing() {
        super("Главный маркетолог", Department.MARKETING, new BigDecimal(1000), new BigDecimal(2000));
    }
}
