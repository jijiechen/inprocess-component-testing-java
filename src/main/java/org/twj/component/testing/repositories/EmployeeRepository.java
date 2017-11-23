package org.twj.component.testing.repositories;


import org.springframework.data.repository.CrudRepository;
import org.twj.component.testing.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {  }


