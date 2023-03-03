package employeeManager.positions.marketing;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class Trainee extends Position {
    public Trainee() {
        super("Стажёр", Department.MARKETING, new BigDecimal(300), new BigDecimal(600));
    }
}
