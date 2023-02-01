package branching;

public class Task2 {
    public static void main(String[] args) {
        final String BANK = "Bank", HEALTH = "Health", TRANSPORT = "Transport";
        int profit = 350945;
        int tax;
        double total;

        String industry = HEALTH;
        switch (industry){
            case BANK: {
                if (profit < 250000) tax = 10;
                else if (profit < 500000) tax = 15;
                else tax = 18;
                break;
            }
            case HEALTH: {
                if (profit < 400000) tax = 7;
                else if (profit < 900000) tax = 12;
                else tax = 15;
                break;
            }
            case TRANSPORT: {
                if (profit < 100000) tax = 9;
                else if (profit < 300000) tax = 13;
                else tax = 17;
                break;
            }
            default: tax = 0;
        }
        total = profit * tax / 100d;
        System.out.println("Налог на сумму "+profit+" для отрасли "+industry+" составляет "+total+". Это составляет "+tax+" процентов");
    }
}
