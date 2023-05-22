package dev.newbcoder_f5.araararauna.controller;

import dev.newbcoder_f5.araararauna.model.Employee;
import dev.newbcoder_f5.araararauna.service.EmployeeService;
import dev.newbcoder_f5.araararauna.service.EmployeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    // localhost:8080/employees/5068100
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id);
    }

    // localhost:8080/employees?id=1578396
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName (@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation (@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByNameKeyword (@RequestParam String keyword) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameOrLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation (@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameOrLocationCustom/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocationCustom(@PathVariable String name, @PathVariable String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocationCustom(name, location), HttpStatus.OK);
    }

    @DeleteMapping("/employees/deleteByNameCustom/{name}")
    public ResponseEntity<String> deleteEmployeesByNameCustom(@PathVariable String name) {
        return new ResponseEntity<String>(employeeService.deleteEmployeesByNameCustom(name) + " no. of records deleted", HttpStatus.OK);
    }

}
