package org.twj.component.testing.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twj.component.testing.models.Employee;
import org.twj.component.testing.repositories.EmployeeRepository;


@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, String>, EmployeeRepository {
}
