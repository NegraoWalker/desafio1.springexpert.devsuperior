package com.walker.desafio1.springexpert.devsuperior.model.dto;

import com.walker.desafio1.springexpert.devsuperior.model.domain.Employee;

public class EmployeeDTO {
    //fields:
    private Long id;
    private String name;
    private String email;
    private Long departmentId;

    //constructors:
    public EmployeeDTO() {
    }
    public EmployeeDTO(Long id, String name, String email, Long departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.departmentId = employee.getDepartment().getId();
    }

    //getters and setters:
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
