package com.smb.theatre.controller;

import com.smb.theatre.model.Employee;
import com.smb.theatre.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showHome (Model model) {
        return "home";
    }

    // Redirect if the user is already logged in.
    @GetMapping("/login")
    public String loginPage (Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/greeting")
    public String greeting (@RequestParam(name="name",
            required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


    /*
    @GetMapping("/employee/registration")
    public String showRegistrationForm (WebRequest request, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee", employeeDto);
        return "registration"; // Registration HTML page.
    }

    @PostMapping("/employee/registration")
    public ModelAndView registerEmployee (
            @ModelAttribute("employee") @Valid EmployeeDto employeeDto,
            HttpServletRequest request,
            Errors errors)  {

        try {
            Employee registered = employeeService.registerNewEmployee(employeeDto);
        } catch (EmployeeAlreadyExistException eaeEx) {
            mav.addObject("message", "An employee for that username/email already registered.");
            return mav;
        }

        return new ModelAndView("successRegister", "employee", employeeDto);
    }

    @PostMapping("/save")
    public String registerUser (@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "display_form";
    }

    // Serve the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Return the login HTML page
    }
    */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll () {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.FOUND);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getUserById (@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveUser (@RequestBody Employee Employee) {
        Employee employee = employeeService.create(Employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateUser (@PathVariable Long id,
                                                @RequestBody Employee Employee)
    {
        Employee updatedEmployee = employeeService.update(id, Employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteUserById (@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
