package com.example.demo.controller;

import com.example.demo.dto.EmployeeCreateRequest;
import com.example.demo.dto.EmployeeUpdateRequest;
import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> createEmployee(
            @Valid @RequestBody EmployeeCreateRequest request,
            BindingResult bindingResult) {

        // バリデーションエラーがある場合、400 Bad Request を返す
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // 正常時の処理
        Employee createdEmployee = employeeService.create(request);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
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