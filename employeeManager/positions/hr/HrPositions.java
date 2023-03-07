package employeeManager.positions.hr;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum HrPositions {
    HEAD(new HeadOfHR()), MANAGER(new Manager()), SENIOR(new SeniorManager());

    private Position position;

    HrPositions(AbstractPosition position){
        this.position = position;
    }

    @Override
    public String toString() {
        return position.getName()+String.format(" (ЗП: мин = %s, макс = %s)",position.getMinSalary(),position.getMaxSalary());
    }

    public Position getPosition(){
        return position;
    }
}
