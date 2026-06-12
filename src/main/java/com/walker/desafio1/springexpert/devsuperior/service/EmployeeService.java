package com.walker.desafio1.springexpert.devsuperior.service;

import com.walker.desafio1.springexpert.devsuperior.model.domain.Department;
import com.walker.desafio1.springexpert.devsuperior.model.domain.Employee;
import com.walker.desafio1.springexpert.devsuperior.model.dto.EmployeeDTO;
import com.walker.desafio1.springexpert.devsuperior.repository.DepartmentRepository;
import com.walker.desafio1.springexpert.devsuperior.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    //injeção de dependências:
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    //constructors:
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    //métodos:
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(EmployeeDTO::new);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        copyDTOToEntity(employeeDTO, employee);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee);
    }

    //métodos auxiliares:
    private void copyDTOToEntity(EmployeeDTO dto, Employee entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        Department department = departmentRepository.getReferenceById(dto.getDepartmentId());
        entity.setDepartment(department);
    }
}
