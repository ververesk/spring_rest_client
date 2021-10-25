package com.grigorovich.spring.rest;

import com.grigorovich.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL="http://localhost:8080/spring_coure_rest/api/employees"; //константа URL
    public List<Employee> getAllEmployees() { //ResponseEntity обертка респонса, принимает лист работников
        ResponseEntity<List<Employee>> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        }); //принимает url, затем метод в данном случае гет, тело отсутствует значит null, ParameterizedTypeReference<List<Employee>> вспомог класс уель которого передача дженерик типа
        List<Employee> allEmployee=responseEntity.getBody();
        return allEmployee;
    }

    public Employee getEmployee(int id) { //получаем работника по id
        Employee employee=restTemplate.getForObject(URL+"/"+id,Employee.class); //добавляем к url id
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id=employee.getId();
        if(id==0) {
            ResponseEntity<String> responseEntity= //postForEntity c помощью POST добавяем работника, String потому что выводим с помощью JSON
                    restTemplate.postForEntity(URL,employee,String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID="+id+" was updated");
        }

    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL+"/"+id);
        System.out.println("Employee with ID="+id+" was deleted from DataBase");
    }
}
