package com.walker.desafio1.springexpert.devsuperior.model.dto;

import com.walker.desafio1.springexpert.devsuperior.model.domain.Department;

public class DepartmentDTO {
    //fields:
    public Long id;
    public String name;
    //constructors:
    public DepartmentDTO() {
    }
    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
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
}
