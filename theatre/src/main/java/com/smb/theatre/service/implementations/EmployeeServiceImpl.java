package com.smb.theatre.service.implementations;

import com.smb.theatre.exception.EmployeeAlreadyExistsException;
import com.smb.theatre.model.Department;
import com.smb.theatre.model.Employee;
import com.smb.theatre.model.Project;
import com.smb.theatre.exception.NotFoundException;
import com.smb.theatre.model.dto.EmployeeDto;
import com.smb.theatre.repository.DepartmentRepository;
import com.smb.theatre.repository.ProjectRepository;
import com.smb.theatre.repository.EmployeeRepository;
import com.smb.theatre.service.interfaces.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ProjectRepository projectRepository;

    /*
    @Override
    public Employee registerNewEmployee (EmployeeDto employeeDto)
    {
        if (emailExists(employeeDto.getEmail())) {
            throw new EmployeeAlreadyExistsException("There is an employee with that email address: "
            + employeeDto.getEmail());
        }

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPassword(employeeDto.getPassword());
        employee.setEmail(employeeDto.getEmail());
        employee.setRoles(List.of("ROLE_EMPLOYEE"));

        return employeeRepository.save(employee);
    }
    private boolean emailExists (String email) {
        return employeeRepository.findByEmail(email) != null;
    }
     */

    @Override
    public List<Employee> findAll () {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new NotFoundException("No users found.");
        }

        return employees;
    }

    @Override
    public Employee findById (Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id does not exist."));
    }

    @Override
    public Employee create (Employee employee) {

        // Retrieve the Department and Project from database based on their IDs
        Department department = null;
        Project project = null;

        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            department = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new NotFoundException("Department not found."));
        }

        if (employee.getProject() != null && employee.getProject().getId() != null) {
            project = projectRepository.findById(employee.getProject().getId())
                    .orElseThrow(() -> new NotFoundException("Project not found."));
        }

        // Save Department and Project
        employee.setDepartment(department);
        employee.setProject(project);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update (Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));

        existingEmployee = employee;

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void delete (Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User with the given id not found."));
        employeeRepository.deleteById(id);
    }
}
