package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for listing employees
    @GetMapping("/listEmployees")
    public String listEmployees(Model model) {
        //get Employees from database
        List<Employee> employees = employeeService.findAll();

        //add to spring model
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        //create model attribute to bind form data
        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save the employee
        //use a redirect to prevent multiple
        employeeService.save(employee);

        return "redirect:/employees/listEmployees";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        // get the employee from the service
        Employee employee = employeeService.findById(theId);
        // set employee in the model to prepopulate the form
        model.addAttribute("employee", employee);
        //send over to our form

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/listEmployees";
    }
}
