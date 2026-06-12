package com.walker.desafio1.springexpert.devsuperior.controller;

import com.walker.desafio1.springexpert.devsuperior.model.dto.DepartmentDTO;
import com.walker.desafio1.springexpert.devsuperior.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departments")
public class DeparmentController {
    //injeção de dependências:
    private final DepartmentService departmentService;

    //constructors:
    public DeparmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //métodos:
    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> departmentDTOList = departmentService.findAll();
        return ResponseEntity.ok(departmentDTOList);
    }
}
