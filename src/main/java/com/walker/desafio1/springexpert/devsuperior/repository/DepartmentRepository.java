package com.walker.desafio1.springexpert.devsuperior.repository;

import com.walker.desafio1.springexpert.devsuperior.model.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> findAllByOrderByNameAsc();
}
