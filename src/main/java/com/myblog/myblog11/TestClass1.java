package com.myblog.myblog11;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {

//        List<Login> logins = Arrays.asList(new Login("mike", "testing"),
//                new Login("stalin","testing"),
//                new Login("adam", "testing")
//        );
//
//        List<LoginDto> dtos = logins.stream().map(login->mapToDto(login)).collect(Collectors.toList());
//        System.out.println(dtos);
//
//
//    }
//
//    static LoginDto mapToDto(Login login){
//        LoginDto dto = new LoginDto();
//        dto.setUserName(login.getUserName());
//        dto.setPassword(login.getPassword());
//        return dto;

        //Find the object whose age is greater than 30

//        List<Employee> employees = Arrays.asList(new Employee("mike",30,"chennai"),
//                new Employee("stalin", 25,"chennai"),
//                new Employee("adam",31,"Pune"),
//                new Employee("sam",34,"Bangalore")
//                );
//
//        List<Employee> emps = employees.stream().filter(emp->emp.getAge()>30).collect(Collectors.toList());
//        for(Employee e:emps){
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//            System.out.println(e.getCity());
//        }

        //Find the list of employees whose name starts with A

//        List<String> name = Arrays.asList("Adam", "Stalin", "Ankit", "Mike");
//        List<String> nameStartWith = name.stream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
//        System.out.println(nameStartWith);
//        }

//        List<Integer> numbers = Arrays.asList(10,12,6,5,7,8,9);
//        List<Integer> data = numbers.stream().filter(e -> e % 2 == 0).map(e -> e * e).collect(Collectors.toList());
//        System.out.println(data);

        //Group By

        List<Employee> employee = Arrays.asList(
                new Employee("Mike",30,"Chennai"),
                new Employee("Adam",25,"Chennai"),
                new Employee("Stallin",34,"Pune"),
                new Employee("Sam",34,"Bangalore")
        );

//        Map<Integer, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(e -> e.getAge()));
//
//        for(Map.Entry<Integer, List<Employee>> entry : collect.entrySet()){
//            int age = entry.getKey();
//            List<Employee> employeeWithAge = entry.getValue();
//            System.out.println("age: "+age+"------");
//            for (Employee e:employeeWithAge){
//                System.out.println(e.getCity());
//                System.out.println(e.getName());
//            }
//        }
        Map<String, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(e -> e.getCity()));

        for(Map.Entry<String, List<Employee>> entry : collect.entrySet()){
            String city = entry.getKey();
            List<Employee> employeesWithCity = entry.getValue();
            System.out.println("City: "+city+"-------");
            for (Employee e: employeesWithCity){
                System.out.println(e.getName());
                System.out.println(e.getAge());
            }
        }
    }
}