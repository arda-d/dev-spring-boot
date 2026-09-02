package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    private JsonMapper jsonMapper;


    //inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    //expose "/employees" endpoints
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    //add mapping for GET/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
         employee.setId(0);

         Employee dbemployee = employeeService.save(employee);

         return dbemployee;
    }

    //add mapping for PUT /employees - update
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        Employee dbemployees = employeeService.save(employee);

        return dbemployees;
    }

    //add mapping for PATCH /employees/{employeesId} - partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> map) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        if (map.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body");
        }

        Employee patchEmployee = jsonMapper.updateValue(employee, map);

        return employeeService.save(patchEmployee);
    }

    //add mapping for DELETE /employees/{employeeId} - delete

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.delete(employeeId);

        return "Employee with id " + employeeId + " deleted";
    }
}
