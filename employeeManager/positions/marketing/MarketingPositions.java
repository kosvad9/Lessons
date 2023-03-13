package employeeManager.positions.marketing;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum MarketingPositions {
    TRAINEE(new Trainee()), SPECIALIST(new Specialist()), HEAD(new HeadOfMarketing());

    private final Position position;

    MarketingPositions(AbstractPosition position){
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
        MarketingPositions[] positions = MarketingPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i < positions.length-1) return positions[++i].getPosition();
        return null;
    }

    public static Position getPrevPosition(Position pos){
        MarketingPositions[] positions = MarketingPositions.values();
        for (int i = 0; i < positions.length; i++)
            if (positions[i].getPosition() == pos)
                if (i > 0) return positions[--i].getPosition();
        return null;
    }
}
