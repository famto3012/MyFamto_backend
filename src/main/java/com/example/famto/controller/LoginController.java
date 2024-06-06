package com.example.famto.controller;

import com.example.famto.entity.Login;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")

public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    // get all logins
    @GetMapping
    public List<Login> getAllLogins() {
        return this.loginRepository.findAll();

    }

    // get login by id
    @GetMapping("/{loginId}")
    public Login getLoginById(@PathVariable(value = "loginId") long loginId) {
        return this.loginRepository.findById(loginId).orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
    }

    // create login
    @PostMapping

    public Login createLogin(@RequestBody Login login) {

        return this.loginRepository.save(login);

    }

    // update login
    @PutMapping("/{loginId}")
    public Login updateLogin(@RequestBody Login login, @PathVariable("loginId") long loginId) {
        Login existingLogin = this.loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
        if (login.getPhoneNumber() != null) {
            existingLogin.setPhoneNumber(login.getPhoneNumber());
        }
        if (login.getName() != null) {
            existingLogin.setName(login.getName());
        }
        if (login.getAddress() != null) {
            existingLogin.setAddress(login.getAddress());
        }
        return this.loginRepository.save(existingLogin);
    }

    // delete login by id
    @DeleteMapping("/{loginId}")
    public ResponseEntity<Login> deleteLogin(@PathVariable("loginId") long loginId) {
        Login existingLogin = this.loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with loginId :" + loginId));
        this.loginRepository.delete(existingLogin);
        return ResponseEntity.ok().build();
    }

}
