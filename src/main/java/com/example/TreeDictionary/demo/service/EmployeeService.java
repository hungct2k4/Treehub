package com.example.TreeDictionary.demo.service;


import com.example.TreeDictionary.demo.Dto.EmployeeDTO;
import com.example.TreeDictionary.demo.Dto.LoginDTO;
import com.example.TreeDictionary.demo.Response.LoginMesage;



public interface EmployeeService {
    LoginMesage addEmployee(EmployeeDTO employeeDTO);

    LoginMesage loginEmployee(LoginDTO loginDTO);

}