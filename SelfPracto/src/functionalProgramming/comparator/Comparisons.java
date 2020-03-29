package functionalProgramming.comparator;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.function.Consumer;

public class Comparisons {
    public static void main(String[] args) {
        Employee mike = new Employee("Mike", 2000),
                rachel = new Employee("rachel", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        System.out.println("Comparison by Name");
        System.out.println(byName.compare(rachel, mike));

        //  New method in the Comparator interface which accepts null and doesnt return
        //  Null pointer exception, while it keeps null in the end and doesnt throw exceptions
        //  The opposite of nullsLast is nullFirst.
        Comparator<Employee> byNameNull = Comparator.nullsLast(byName);
        System.out.println(byNameNull.compare(null, mike));
        System.out.println(byNameNull.compare(mike, null));

        //  Writing the same comparator method using Lambda expression
        Comparator<Employee> compareEmpNameLengths =
            (Employee e1, Employee e2) -> { return e1.getName().length() - e2.getName().length();};

        Comparator<Employee> compareNameUsingLmbda =
                (a, b) -> a.getName().compareTo(b.getName());

        //  Creating a thread using runnable and Lambda
        Runnable r = () -> System.out.println("Printing from inside Thread");
        Thread th1 = new Thread(r);

        //  Combining the above two lines together into one
        Thread th2 = new Thread( () -> System.out.println("Printing from inside 2nd Thread"));

        //  Writing lambda expression for a functional interface Consumer and implementing the single abstract method accept using lambda
        Consumer<String> lengthPrinter = s -> System.out.println(s.length());

        

    }

}
