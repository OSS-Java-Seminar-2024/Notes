package com.smb.theatre.controller;

import com.smb.theatre.model.User;
import com.smb.theatre.model.dto.UserDto;
import com.smb.theatre.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @GetMapping("/greeting")
    public String greeting (@RequestParam(name="name",
            required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }

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


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll () {
        List<UserDto> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity<User> saveUser (@RequestBody User User) {
        User user = userService.create(User);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id,
                                            @RequestBody User User)
    {
        User updatedUser = userService.update(id, User);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteUserById (@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
}
