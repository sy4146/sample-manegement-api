package com.example.demo.service;

import com.example.demo.dto.EmployeeCreateRequest;
import com.example.demo.dto.EmployeeUpdateRequest;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(EmployeeCreateRequest request) {
        try {
            Employee employee = new Employee();
            employee.setName(request.getName());
            employee.setImage(request.getImage());
            employee.setGender(request.getGender());
            employee.setHireDate(LocalDate.parse(request.getHireDate()));
            employee.setMailAddress(request.getMailAddress());
            employee.setZipCode(request.getZipCode());
            employee.setAddress(request.getAddress());
            employee.setTelephone(request.getTelephone());
            employee.setSalary(request.getSalary());
            employee.setCharacteristics(request.getCharacteristics());
            employee.setDependentsCount(request.getDependentsCount());

            return employeeRepository.save(employee);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create employee: " + ex.getMessage());
        }
    }
    // public List<Employee> findAll() {
    // return employeeRepository.findAll();
    // }

    // public Employee findById(Integer id) {
    // return employeeRepository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
    // "Employee not found"));
    // }

    // public Employee update(Integer id, EmployeeUpdateRequest req) {
    // Employee emp = employeeRepository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
    // "Employee not found"));

    // emp.setName(req.getName());
    // emp.setImage(req.getImage());
    // emp.setGender(req.getGender());
    // if (req.getHireDate() != null) {
    // emp.setHireDate(LocalDate.parse(req.getHireDate()));
    // }
    // emp.setMailAddress(req.getMailAddress());
    // emp.setZipCode(req.getZipCode());
    // emp.setAddress(req.getAddress());
    // emp.setTelephone(req.getTelephone());
    // emp.setSalary(req.getSalary());
    // emp.setCharacteristics(req.getCharacteristics());
    // emp.setDependentsCount(req.getDependentsCount());

    // return employeeRepository.save(emp);
    // }

    // public void delete(Integer id) {
    // if (!employeeRepository.existsById(id)) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not
    // found");
    // }
    // employeeRepository.deleteById(id);
    // }
}