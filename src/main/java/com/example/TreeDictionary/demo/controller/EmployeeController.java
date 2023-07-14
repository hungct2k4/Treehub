package com.example.TreeDictionary.demo.controller;


import com.example.TreeDictionary.demo.Dto.EmployeeDTO;
import com.example.TreeDictionary.demo.Dto.LoginDTO;
import com.example.TreeDictionary.demo.Response.LoginMesage;
import com.example.TreeDictionary.demo.service.EmployeeService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        LoginMesage loginMesage = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(loginMesage);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginMesage loginMesage = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMesage);
    }
}
