package employeeManager.positions.hr;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum HrPositions {
    MANAGER(new Manager()), SENIOR(new SeniorManager()), HEAD(new HeadOfHR());

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

    public static Position getNextPosition(Position pos){
        HrPositions[] positions = HrPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i < positions.length-1) return positions[++i].getPosition();
        return null;
    }

    public static Position getPrevPosition(Position pos){
        HrPositions[] positions = HrPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i > 0) return positions[--i].getPosition();
        return null;
    }
}
