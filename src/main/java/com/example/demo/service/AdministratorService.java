package com.example.demo.service;

import com.example.demo.dto.AdministratorCreateRequest;
import com.example.demo.dto.AdministratorUpdateRequest;
import com.example.demo.domain.Administrator;
import com.example.demo.repository.AdministratorRepository;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    public Administrator findById(Integer id) {
        return administratorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Administrator not found: " + id));
    }

    public Administrator create(AdministratorCreateRequest req) {
        Administrator admin = new Administrator(req.getName(), req.getMailAddress(), req.getPassword());
        return administratorRepository.save(admin);
    }

    public Administrator update(Integer id, AdministratorUpdateRequest req) {
        Administrator admin = administratorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Administrator not found: " + id));

        admin.setName(req.getName());
        admin.setMailAddress(req.getMailAddress());
        admin.setPassword(req.getPassword());

        return administratorRepository.save(admin);
    }

    public void delete(Integer id) {
        if (!administratorRepository.existsById(id)) {
            throw new NotFoundException("Administrator not found: " + id);
        }
        administratorRepository.deleteById(id);
    }
}