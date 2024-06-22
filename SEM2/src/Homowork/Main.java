package Homowork;

public class Main {

    public static void main(String[] args) {
        Integer a = 1000;
        Double b = 43.123123;
        Pair<Integer, Double> pair = new Pair<>(a,b);
        double result = sum(pair);
        System.out.println("Сумма: " + result);
    }

    public static <T extends Number, U extends Number> double sum(Pair<T, U> pair) {
        return pair.getFirst().doubleValue() + pair.getSecond().doubleValue();
    }
}
