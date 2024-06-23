/**
 * 1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
 * Параметры этих методов два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number,V extends Number> void sum(T firstNumber, V secondNumber){
        Double result = firstNumber.doubleValue() + secondNumber.doubleValue();
        System.out.println(result);
    }

    public static <T extends Number, V extends Number> void multiply(T firstNumber, V secondNumber){
        Double result = firstNumber.doubleValue() * secondNumber.doubleValue();
        System.out.println(result);
    }

    public static <T extends Number, V extends Number> void divide(T firstNumber, V secondNumber){
        Double result = firstNumber.doubleValue() / secondNumber.doubleValue();
        System.out.println(result);
    }

    public static <T extends Number, V extends Number> void subtract(T firstNumber, V secondNumber){
        Double result = firstNumber.doubleValue() - secondNumber.doubleValue();
        System.out.println(result);
    }

}
