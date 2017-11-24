package org.twj.component.testing;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import org.twj.component.testing.models.Employee;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DbDependencyControllerTest extends BaseTest {


    @Autowired
    private DbDependencyController dbDependencyCtrl;
    @Autowired
    private EntityManager entityManager;


    @Test
    @Transactional
    public void should_serve_content_from_in_mem_db() throws IOException {
        this.entityManager.persist(new Employee("Jim", "1234"));
        this.entityManager.persist(new Employee("Kite", "3456"));

        List<Employee> employees = dbDependencyCtrl.getEmployees();

        assertEquals(2, employees.size());

        assertEquals("Jim", employees.get(0).getName());
        assertEquals("Kite", employees.get(1).getName());
    }

    @Test
    @Transactional
    public void should_serve_transformed_employee_display_name_from_in_mem_db() throws IOException {
        this.entityManager.persist(new Employee("Jim", "1234"));
        this.entityManager.persist(new Employee("Kite", "3456"));

        String displayName = dbDependencyCtrl.getEmployeeName("3456");

        assertEquals("Kite3456", displayName);
    }

}
