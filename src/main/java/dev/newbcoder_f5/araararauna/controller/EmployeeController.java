package dev.newbcoder_f5.araararauna.controller;

import dev.newbcoder_f5.araararauna.model.Department;
import dev.newbcoder_f5.araararauna.model.Employee;
import dev.newbcoder_f5.araararauna.repository.DepartmentRepository;
import dev.newbcoder_f5.araararauna.repository.EmployeeRepository;
import dev.newbcoder_f5.araararauna.request.EmployeeRequest;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

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
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
//        Department dept = new Department();
//        dept.setName(eRequest.getDepartment());
//
//        dept = departmentRepository.save(dept);
//
//        Employee employee = new Employee(eRequest);
//        employee.setDepartment(dept);
//
//        employeeRepository.save(employee);
//
//        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

        Employee employee = new Employee(eRequest);
        employeeRepository.save(employee);

        for (String s : eRequest.getDepartment()) {

            Department dept = new Department();
            dept.setName(s);
            dept.setEmployee(employee);

            departmentRepository.save(dept);

        }

        return new ResponseEntity<String>("record saved successfully", HttpStatus.CREATED);

//        return null;

    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

}
