public class Task2 {
    /*
     * 2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
     * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
     */


    public static <T, V> boolean compareArrays(T [] firstArray, V [] secondArray) {
        if (firstArray.length == secondArray.length && firstArray.getClass().equals(secondArray.getClass())) {
            return true;
        }
        return false;
    }
}
