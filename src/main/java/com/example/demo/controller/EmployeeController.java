package com.example.demo.controller;

import com.example.demo.dto.EmployeeCreateRequest;
import com.example.demo.dto.EmployeeUpdateRequest;
import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員登録 (POST /employees)
     * 成功時は201 Createdを返す
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody EmployeeCreateRequest request) {
        return employeeService.create(request);
    }
    // // 従業員一覧取得 (GET /employees) (任意)
    // @GetMapping
    // public ResponseEntity<List<Employee>> getAllEmployees() {
    // List<Employee> employees = employeeService.findAll();
    // return ResponseEntity.ok(employees);
    // }

    // // 従業員個別取得 (GET /employees/{id}) (任意)
    // @GetMapping("/{employeeId}")
    // public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId)
    // {
    // Employee emp = employeeService.findById(employeeId);
    // return ResponseEntity.ok(emp);
    // }

    // // 従業員更新 (PUT /employees/{id}) (任意)
    // @PutMapping("/{employeeId}")
    // public ResponseEntity<Employee> updateEmployee(@PathVariable Integer
    // employeeId,
    // @RequestBody EmployeeUpdateRequest request) {
    // Employee updated = employeeService.update(employeeId, request);
    // return ResponseEntity.ok(updated);
    // }

    // // 従業員削除 (DELETE /employees/{id}) (任意)
    // @DeleteMapping("/{employeeId}")
    // public ResponseEntity<Void> deleteEmployee(@PathVariable Integer employeeId)
    // {
    // employeeService.delete(employeeId);
    // return ResponseEntity.noContent().build(); // 204
    // }
}