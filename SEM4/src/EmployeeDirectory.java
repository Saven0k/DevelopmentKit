import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создать справочник сотрудников
 * Необходимо:
 * Создать класс справочник сотрудников, который содержит внутри
 * Коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDirectory {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> employees = new ArrayList<>();
        employees.add(new ArrayList<>(
                Arrays.asList("123", "89999999999", "Max", "5")));
        employees.add(new ArrayList<>(
                Arrays.asList("124", "8999999911", "Vova", "2")));
        employees.add(new ArrayList<>(
                Arrays.asList("121", "8999999944", "Vera", "7")));
        employees.add(new ArrayList<>(
                Arrays.asList("125", "8999999922", "Gora", "8")));
        employees.add(new ArrayList<>(
                Arrays.asList("126", "8999999933", "Vera", "2")));
        System.out.println(String.format("Начальный список сотрудников: %s", String.valueOf(employees)));

        System.out.println(String.format("Сотрудники со стажем 2 года: %s", findEmployeesByExp(employees, "2")));

        System.out.println(String.format("Номер телефона сотрудников по имени 'Vera': %s", findPhoneNumberByName( "Vera", employees)));

        System.out.println(String.format("Сотрудник с номером мобильного телефона %s: %s", "8999999922", findEmployeeByNumberPhone(employees,"8999999922" )));

        System.out.println(String.format("Добавляем сотрудника с именем %s, номером телефона %s, табельным номер %s, стажем работы %s: %s", "Roma", "89999999910", "111", "1",
                addNewEmployee(employees, "Roma", "89999999910", "1", "111") ));
    }


    // * Добавить метод, который ищет сотрудника по стажу (может быть список)
    public static ArrayList<ArrayList<String>> findEmployeesByExp(ArrayList<ArrayList<String>> employees,String exp) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<String> employee : employees) {if (employee.get(3).equals(exp)) {result.add(employee);}}
        return result;
    }


    // * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    public static ArrayList<String> findPhoneNumberByName(String name, ArrayList<ArrayList<String>> employees ) {
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> employee : employees) {
            if (employee.get(2).equals(name)) {
               result.add(employee.get(1));
            }
        }
        return result;
    }


    //* Добавить метод, который ищет сотрудника по табельному номеру
    public static ArrayList<String>findEmployeeByNumberPhone(ArrayList<ArrayList<String>> employees, String phone) {
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> employee : employees) {
            if (employee.get(1).equals(phone)) {
                result.addAll(employee);
            }
        }
        return result;
    }


    // * Добавить метод добавление нового сотрудника в справочник
    public static ArrayList<ArrayList<String>> addNewEmployee(
            ArrayList<ArrayList<String>> employees,
            String name,
            String phone,
            String exp,
            String personnelNumber) {
        employees.add(new ArrayList<>(
                Arrays.asList(personnelNumber, phone, name, exp)
        ));
        return employees;
    }
}
