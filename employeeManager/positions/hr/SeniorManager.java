package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class SeniorManager extends Position {
    public SeniorManager() {
        super("Senior Менеджер", Department.HR, new BigDecimal(700), new BigDecimal(1100));
    }
}