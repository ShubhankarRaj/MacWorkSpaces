package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by raj8lm on 29/08/18.
 */

public class Main {
    public static void main(String[] args) {
        //new Thread(new CodeToRun()).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from Runnable Interface");
            }
        }).start();*/

        new Thread(() -> System.out.println("Printing from Lambda Expressions.")).start();

        Employee ravi = new Employee("Ravi Mude", 30);
        Employee raj = new Employee("Raj", 35);
        Employee niks = new Employee("Niharika", 27);
        Employee tejas = new Employee("Tejas", 21);

        List<Employee> listofEmployee = new ArrayList<>();
        listofEmployee.add(raj);
        listofEmployee.add(ravi);
        listofEmployee.add(niks);
        listofEmployee.add(tejas);

        //  Sorting the Employees in Descending order
        Collections.sort(listofEmployee, (emp1, emp2) -> emp1.getName().compareToIgnoreCase(emp2.getName()));
        listofEmployee.forEach(employee -> {
            System.out.println("NAME: "+employee.getName());
            System.out.println("AGE: "+employee.getAge());
        });
/*
        for(Employee emp:listofEmployee)
            System.out.println(emp.getName());

        String someNewString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, listofEmployee.get(0).getName(), listofEmployee.get(1).getName());

        System.out.println(someNewString);

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String someSillyStuff = doStringStuff(uc, listofEmployee.get(2).getName(), listofEmployee.get(3).getName());
        System.out.println(someSillyStuff);

*/

        AnotherClass anotherClass = new AnotherClass();
        String anotherString = anotherClass.doSomething();
        System.out.println(anotherString);
    }


    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

/*class CodeToRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Printing from the Runnable inside CodeToRun");
    }
}*/
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        System.out.println("The another class's name is "+getClass().getSimpleName());

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The class name should be "+getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        };

        return Main.doStringStuff(uc, "String1", "String2");
        /*return Main.doStringStuff(new UpperConcat() {
                                      @Override
                                      public String upperAndConcat(String s1, String s2) {
                                          System.out.println("The another class name inside Interface's over-ridden method is "+getClass().getSimpleName());
                                          return s1.toUpperCase() + s2.toUpperCase();
                                      }
                                  }, "String1", "String2"
        );*/
    }
}
