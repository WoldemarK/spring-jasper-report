package com.example.springjasperreport.controller;

import com.example.springjasperreport.entity.Employee;
import com.example.springjasperreport.repository.EmployeeRepository;
import com.example.springjasperreport.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService service;
    private final EmployeeRepository repository;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }
    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

}
