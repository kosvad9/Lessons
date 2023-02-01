package branching;

public class Task1 {
    public static void main(String[] args) {
        int examResult = 74;
        if (examResult >= 1 && examResult <= 100){
            if (examResult <= 25) System.out.println("Плохо");
            else if (examResult <= 50) System.out.println("Ниже среднего");
            else if (examResult <= 75) System.out.println("Средне");
            else if (examResult <= 100) System.out.println("Отлично");
        }
        else System.out.println("Ошибка");
    }
}
