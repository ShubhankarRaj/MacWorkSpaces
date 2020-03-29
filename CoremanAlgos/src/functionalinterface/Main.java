package functionalinterface;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by raj8lm on 31/08/18.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Printing from Lambda Expressions.")).start();

        Employee ravi = new Employee("Ravi Mude", 30);
        Employee raj = new Employee("Raj Malhotra", 35);
        Employee niks = new Employee("Niharika Das", 27);
        Employee tejas = new Employee("Tejas Mishra", 21);
        Employee shakeel = new Employee("Chota Shakeel", 20);

        List<Employee> listofEmployee = new ArrayList<>();
        listofEmployee.add(raj);
        listofEmployee.add(ravi);
        listofEmployee.add(niks);
        listofEmployee.add(tejas);
        listofEmployee.add(shakeel);

        //  Sorting the Employees in Descending order
        Collections.sort(listofEmployee, (emp1, emp2) -> emp1.getName().compareToIgnoreCase(emp2.getName()));
        listofEmployee.forEach(employee -> {
            System.out.println("NAME: "+employee.getName());
            System.out.println("AGE: "+employee.getAge());
        });

        //  Using Predicates with Lambda Expressions
        printEmployeeByAge(listofEmployee, "Printing all employees above 30", employee -> employee.getAge() > 30);
        printEmployeeByAge(listofEmployee, "\nPrinting all employees less/equal to 30", employee -> employee.getAge() <= 30);

        //  Using Predicates with Anonymous Expressions
        printEmployeeByAge(listofEmployee, "\nPrinting all employees less than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //  Chaining predicates together
        IntPredicate greaterThan10 = i -> i >10;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println("\n"+(greaterThan10).and(lessThan100).test(50));

        //  Supplier Interface
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        for(int i = 0; i < 10; i++)
            System.out.println(randomSupplier.get());

        listofEmployee.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last name is - "+lastName);
        });

        //  The only component which returns a value in return of a parameter is a Functional Interface

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastNameFuncInt = getLastName.apply(listofEmployee.get(2));
        System.out.println(lastNameFuncInt);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random randomBoolean = new Random();
        for(Employee employee: listofEmployee){
            if(randomBoolean.nextBoolean())
                System.out.println("First Name: "+getAnyName(getFirstName, employee));
            else
                System.out.println("Last Name: "+getAnyName(getLastName, employee));
        }

    }

    private static String getAnyName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("###################################");
        for(Employee employee: employees){
            if(ageCondition.test(employee))
                System.out.println(employee.getName());
        };
    }
}
