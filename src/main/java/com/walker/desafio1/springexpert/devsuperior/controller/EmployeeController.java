package com.walker.desafio1.springexpert.devsuperior.controller;

import com.walker.desafio1.springexpert.devsuperior.model.dto.EmployeeDTO;
import com.walker.desafio1.springexpert.devsuperior.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    //injeção de dependências:
    private final EmployeeService employeeService;

    //constructors:
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //métodos:
    @GetMapping()
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
        Page<EmployeeDTO> page = employeeService.findAll(pageRequest);
        return ResponseEntity.ok(page);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployeeDTO = employeeService.insert(employeeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployeeDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newEmployeeDTO);
    }
}
