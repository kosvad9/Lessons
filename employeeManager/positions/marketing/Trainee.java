package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

public class Trainee extends AbstractPosition {
    public Trainee() {
        super("Стажёр", Department.MARKETING, new BigDecimal(300), new BigDecimal(600));
    }
}
