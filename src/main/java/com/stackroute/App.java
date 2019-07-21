package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDao employeeDao = applicationContext.getBean("edao", EmployeeDao.class);
        System.out.println("insertion");
        //insert record into table
        int status=employeeDao.insertIntoemployee(new Employee(102,"Amit",35,"m"));
        System.out.println(status);
        System.out.println("update");
        Employee employee1 = new Employee();
        employee1.setEmployeeId(2);
        //update record based on employeeId
        int status1 = employeeDao.updateEmployee(new Employee(employee1.getEmployeeId(), "Bhargav", 15, "f"));
        System.out.println(status1);

        System.out.println("delete");
    Employee e=new Employee();
e.setEmployeeId(101);
//delete recordbased on employeeId
    int status2=employeeDao.deleteEmployee(e);
    System.out.println(status2);
        System.out.println("retrive");
        //retrive  employee details
        List<Employee> list=employeeDao.retriveEmployees();

        for(Employee e1:list)
            System.out.println(e1);

    }


    }


