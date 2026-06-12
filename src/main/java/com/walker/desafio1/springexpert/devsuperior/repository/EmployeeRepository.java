package com.walker.desafio1.springexpert.devsuperior.repository;

import com.walker.desafio1.springexpert.devsuperior.model.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
