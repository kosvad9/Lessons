package employeeManager.positions.development;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum DevelopmentPositions {
    JUNIOR(new JuniorDeveloper()), MIDDLE(new MiddleDeveloper()), SENIOR(new SeniorDeveloper()), TEAMLEAD(new TeamLead());

    private final Position position;

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

    public static Position getNextPosition(Position pos){
        DevelopmentPositions[] positions = DevelopmentPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i < positions.length-1) return positions[++i].getPosition();
        return null;
    }

    public static Position getPrevPosition(Position pos){
        DevelopmentPositions[] positions = DevelopmentPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i > 0) return positions[--i].getPosition();
        return null;
    }
}
