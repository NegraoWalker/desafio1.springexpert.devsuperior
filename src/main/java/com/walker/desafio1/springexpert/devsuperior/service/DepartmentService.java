package com.walker.desafio1.springexpert.devsuperior.service;

import com.walker.desafio1.springexpert.devsuperior.model.dto.DepartmentDTO;
import com.walker.desafio1.springexpert.devsuperior.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    //injeção de dependências:
    private final DepartmentRepository departmentRepository;

    //constructors:
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    //métodos:
    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        return departmentRepository.findAllByOrderByNameAsc()
                .stream()
                .map(DepartmentDTO::new)
                .toList();
    }
}
