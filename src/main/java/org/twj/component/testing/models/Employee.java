package org.twj.component.testing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    private String name;

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }


    public Employee(String name, String id) {
        this(name);
        this.id = id;
    }


    public String getName() {
        return name;
    }



    @Id
    @Column(length=40)
    private String id;

    public String getId() {
        return id;
    }
}
