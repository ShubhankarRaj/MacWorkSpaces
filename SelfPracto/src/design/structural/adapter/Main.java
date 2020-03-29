package com.design.structural.adapter;

public class Main {

    public static void main(String[] args) {
        /** Using Class two way adapter **/
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        System.out.println(designer.designCard(adapter));

        System.out.println("**************************************");
        /** Using Object Adapter **/
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter objAdapter = new EmployeeObjectAdapter(employee);
        System.out.println(designer.designCard(objAdapter));
    }

    public static void populateEmployeeData(Employee employee){
        employee.setFullName("Shubhankar Raj");
        employee.setJobTitle("S/W Engg");
        employee.setOfficeLocation("Marathahalli, Bangalore");
    }
}
