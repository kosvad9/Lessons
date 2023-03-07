package employeeManager.positions.development;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum DevelopmentPositions {
    JUNIOR(new JuniorDeveloper()), MIDDLE(new MiddleDeveloper()), SENIOR(new SeniorDeveloper()), TEAMLEAD(new TeamLead());

    private Position position;

    DevelopmentPositions(AbstractPosition position){
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
