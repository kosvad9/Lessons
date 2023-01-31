package variables;

public class Task1 {
    public static void main(String[] args) {
        byte byteNumber= 126;
        int plusByte, minusByte, timesByte, incByte, decByte, dividedByte, remainByte;
        plusByte = byteNumber + 1;
        minusByte = byteNumber - 1;
        timesByte = byteNumber * 3;
        incByte = byteNumber++;
        decByte = byteNumber--;
        dividedByte = byteNumber / 5;
        remainByte = byteNumber % 5;
        
        
        
        short shortNumber = 32767;
        int plusShort, minusShort, timesShort, incShort, decShort, dividedShort, remainShort;
        plusShort = shortNumber + 1;
        minusShort = shortNumber - 1;
        timesShort = shortNumber * 3;
        incShort = shortNumber++;
        decShort = shortNumber--;
        dividedShort = shortNumber / 5;
        remainShort = shortNumber % 5;
        
        int intNumber = 2147483647;
        int plusInt, minusInt, timesInt, incInt, decInt, dividedInt, remainInt;
        plusInt = intNumber + 1;
        minusInt = intNumber - 1;
        timesInt = intNumber * 3;
        incInt = intNumber++;
        decInt = intNumber--;
        dividedInt = intNumber / 5;
        remainInt = intNumber % 5;
        
        long longNumber = 922337203685477581l;
        long plusLong, minusLong, timesLong, incLong, decLong, dividedLong, remainLong;
        plusLong = longNumber + 1;
        minusLong = longNumber - 1;
        timesLong = longNumber * 3;
        incLong = longNumber++;
        decLong = longNumber--;
        dividedLong = longNumber / 5;
        remainLong = longNumber % 5;
        
        float floatNumber = 3.14f;
        float plusFloat, minusFloat, timesFloat, incFloat, decFloat, dividedFloat, remainFloat;
        plusFloat = floatNumber + 1f;
        minusFloat = floatNumber - 1f;
        timesFloat = floatNumber * 3f;
        incFloat = floatNumber++;
        decFloat = floatNumber--;
        dividedFloat = floatNumber / 5f;
        remainFloat = floatNumber % 5f;
        
        double doubleNumber = 15243.88675;
        double plusDouble, minusDouble, timesDouble, incDouble, decDouble, dividedDouble, remainDouble;
        plusDouble = doubleNumber + 1d;
        minusDouble = doubleNumber - 1d;
        timesDouble = doubleNumber * 3d;
        incDouble = doubleNumber++;
        decDouble = doubleNumber--;
        dividedDouble = doubleNumber / 5d;
        remainDouble = doubleNumber % 5d;
        
        char charSymbol = 'V';
        boolean bool = true;
        String str = "Hello";
        System.out.println(byteNumber);
        System.out.println(shortNumber);
        System.out.println(intNumber);
        System.out.println(longNumber);
        System.out.println(floatNumber);
        System.out.println(doubleNumber);
        System.out.println(charSymbol);
        System.out.println(bool);
        System.out.println(str);
        System.out.println("Результаты операций с типом byte");
        System.out.println(plusByte+", "+minusByte+", "+timesByte+", "+dividedByte+", "+remainByte+", "+incByte+", "+decByte);
        System.out.println("Результаты операций с типом short");
        System.out.println(plusShort+", "+minusShort+", "+timesShort+", "+dividedShort+", "+remainShort+", "+incShort+", "+decShort);
        System.out.println("Результаты операций с типом int");
        System.out.println(plusInt+", "+minusInt+", "+timesInt+", "+dividedInt+", "+remainInt+", "+incInt+", "+decInt);
        System.out.println("Результаты операций с типом long");
        System.out.println(plusLong+", "+minusLong+", "+timesLong+", "+dividedLong+", "+remainLong+", "+incLong+", "+decLong);
        System.out.println("Результаты операций с типом float");
        System.out.println(plusFloat+", "+minusFloat+", "+timesFloat+", "+dividedFloat+", "+remainFloat+", "+incFloat+", "+decFloat);
        System.out.println("Результаты операций с типом double");
        System.out.println(plusDouble+", "+minusDouble+", "+timesDouble+", "+dividedDouble+", "+remainDouble+", "+incDouble+", "+decDouble);
    }
}
