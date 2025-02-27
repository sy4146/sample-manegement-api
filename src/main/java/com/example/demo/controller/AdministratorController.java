package com.example.demo.controller;

import com.example.demo.dto.AdministratorCreateRequest;
import com.example.demo.dto.AdministratorUpdateRequest;
import com.example.demo.domain.Administrator;
import com.example.demo.service.AdministratorService;

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
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理者一覧取得 (GET /administrators)
     */
    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> admins = administratorService.findAll();
        return ResponseEntity.ok(admins);
    }

    /**
     * 管理者個別取得 (GET /administrators/{administratorId})
     */
    @GetMapping("/{administratorId}")
    public ResponseEntity<Administrator> getAdministrator(@PathVariable Integer administratorId) {
        Administrator admin = administratorService.findById(administratorId);
        return ResponseEntity.ok(admin);
    }

    /**
     * 管理者登録 (POST /administrators)
     * 成功時は201 Createdを返す
     */
    @PostMapping
    public ResponseEntity<?> createAdministrator(
            @Valid @RequestBody AdministratorCreateRequest request,
            BindingResult bindingResult) {

        // バリデーションエラーがある場合、400 Bad Request を返す
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // 正常処理
        Administrator administrator = administratorService.create(request);
        return new ResponseEntity<>(administrator, HttpStatus.CREATED);
    }

    /**
     * 管理者更新 (PUT /administrators/{administratorId})
     */
    @PutMapping("/{administratorId}")
    public ResponseEntity<?> updateAdministrator(
            @PathVariable Integer administratorId,
            @Valid @RequestBody AdministratorUpdateRequest request,
            BindingResult bindingResult) {

        // バリデーションエラーがある場合、400 Bad Request を返す
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // 正常処理
        Administrator updated = administratorService.update(administratorId, request);
        return ResponseEntity.ok(updated);
    }

    /**
     * 管理者削除 (DELETE /administrators/{administratorId})
     * 成功時は204 No Contentを返す
     */
    @DeleteMapping("/{administratorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdministrator(@PathVariable Integer administratorId) {
        administratorService.delete(administratorId);
    }
}