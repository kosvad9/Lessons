package employeeManager.positions.development;

import employeeManager.Department;
import employeeManager.positions.AbstractPosition;

import java.math.BigDecimal;

class TeamLead extends AbstractPosition {
    public TeamLead() {
        super("Team Lead", Department.DEVELOPMENT, new BigDecimal(2500), new BigDecimal(7000));
    }
}
