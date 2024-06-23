public class Main {
    public static void main(String[] args) {

        /*
         * 1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
         * Параметры этих методов два числа разного типа, над которыми должна быть произведена операция.
         */

        Calculator.sum(2.2f, 5);
        Calculator.divide(5, 2.5);
        Calculator.multiply(2.2f, 5);
        Calculator.subtract(2.2f, 5);

        /*
         * 2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
         * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
         */
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        Animal animalArray[];
        animalArray = new Animal[2];
        animalArray[0] = animal;
        animalArray[1] = animal2;

        Dog dog = new Dog("Bobik");
        Dog dog2 = new Dog("Piki");
        Dog dogArray[];
        dogArray = new Dog[2];
        dogArray[0] = dog;
        dogArray[1] = dog2;

        Cat cat = new Cat("Bob");
        Cat cat2 = new Cat("Riki");
        Cat catArray[];
        catArray = new Cat[2];
        catArray[0] = cat;
        catArray[1] = cat2;


        System.out.println(Task2.compareArrays(animalArray, catArray));

    }
}

