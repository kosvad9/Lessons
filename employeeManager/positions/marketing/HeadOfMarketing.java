package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class HeadOfMarketing extends Position {
    public HeadOfMarketing() {
        super("Главный маркетолог", Department.MARKETING, new BigDecimal(1000), new BigDecimal(2000));
    }
}
