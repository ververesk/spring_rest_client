package com.grigorovich.spring.rest;

import com.grigorovich.spring.rest.configuration.MyConfig;
import com.grigorovich.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication=context.getBean("communication", Communication.class);

//        List<Employee> allEmployees=communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empByID=communication.getEmployee(1);
//        System.out.println(empByID);

//        Employee employee=new Employee("Sveta", "Sokolova", "HR",900);
//        employee.setId(10);
//        employee.setSalary(1000);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(10);
    }

}
