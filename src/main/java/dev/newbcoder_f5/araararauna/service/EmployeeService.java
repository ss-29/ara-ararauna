package dev.newbcoder_f5.araararauna.service;

import dev.newbcoder_f5.araararauna.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByNameKeyword(String keyword);

    List<Employee> getEmployeesByNameOrLocation(String name, String location);

    List<Employee> getEmployeesByNameOrLocationCustom(String name, String location);

    Integer deleteEmployeesByNameCustom(String name);


}
