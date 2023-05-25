package dev.newbcoder_f5.araararauna.service;

import dev.newbcoder_f5.araararauna.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

}
