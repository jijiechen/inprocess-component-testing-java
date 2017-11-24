package org.twj.component.testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.twj.component.testing.models.Employee;
import org.twj.component.testing.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDisplayService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String loadEmployeeName(String id) {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();

        employees.forEach(list::add);

        Optional<Employee> matchedEmployee = list.stream().filter((Employee e) -> id.equals(e.getId())).limit(1).findFirst();
        if(matchedEmployee.isPresent()){
            Employee employee = matchedEmployee.get();
            return employee.getName() + employee.getId();
        }
        return null;
    }
}
