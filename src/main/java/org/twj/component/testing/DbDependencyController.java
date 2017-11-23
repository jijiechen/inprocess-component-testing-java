package org.twj.component.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.twj.component.testing.models.Employee;
import org.twj.component.testing.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DbDependencyController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();

        employees.forEach(list::add);
        return list;
    }
}
