package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.Position;

import java.math.BigDecimal;

public class TeamLead extends Position {
    public TeamLead() {
        super("Team Lead", Department.DEVELOPMENT, new BigDecimal(2500), new BigDecimal(7000));
    }
}
