package org.twj.component.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.twj.component.testing.models.Employee;
import org.twj.component.testing.repositories.EmployeeRepository;
import org.twj.component.testing.services.EmployeeDisplayService;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class DbDependencyController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeDisplayService employeeDisplayService;


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();

        employees.forEach(list::add);
        return list;
    }

    @RequestMapping(value = "/employees/{id}/name", method = RequestMethod.GET)
    public String getEmployeeName(String id) {
        return employeeDisplayService.loadEmployeeName(id);
    }
}
