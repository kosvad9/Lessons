package employeeManager.positions.hr;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class Manager extends Position {
    public Manager() {
        super("Менеджер", Department.HR, new BigDecimal(400), new BigDecimal(800));
    }
}
