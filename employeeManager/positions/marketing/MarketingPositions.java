package employeeManager.positions.marketing;

import employeeManager.Position;
import employeeManager.positions.AbstractPosition;

public enum MarketingPositions {
    HEAD(new HeadOfMarketing()), SPECIALIST(new Specialist()), TRAINEE(new Trainee());

    private Position position;

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
}
