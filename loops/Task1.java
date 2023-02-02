package loops;

public class Task1 {
    public static void main(String[] args) {
        String[] strArray = {"John", "Bob", "Mary", "Peter", "Sarah"};

        for (int i = 0; i < strArray.length; i++)
            if (strArray[i].length() < 4) System.out.println("Ваше имя короче 4 букв");
            else if (strArray[i].length() > 4) System.out.println("Ваше имя длиннее 4 букв");
            else System.out.println("Ваше имя состоит из 4 букв");

        for (String elem:strArray)
            if (elem.length() < 4) System.out.println("Ваше имя короче 4 букв");
            else if (elem.length() > 4) System.out.println("Ваше имя длиннее 4 букв");
            else System.out.println("Ваше имя состоит из 4 букв");

        int i = 0;
        while (i < strArray.length){
            if (strArray[i].length() < 4) System.out.println("Ваше имя короче 4 букв");
            else if (strArray[i].length() > 4) System.out.println("Ваше имя длиннее 4 букв");
            else System.out.println("Ваше имя состоит из 4 букв");
            i++;
        }
        i = 0;
        do{
            if (strArray[i].length() < 4) System.out.println("Ваше имя короче 4 букв");
            else if (strArray[i].length() > 4) System.out.println("Ваше имя длиннее 4 букв");
            else System.out.println("Ваше имя состоит из 4 букв");
            i++;
        }while (i < strArray.length);
    }
}
