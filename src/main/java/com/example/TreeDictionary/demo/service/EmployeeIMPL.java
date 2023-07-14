package com.example.TreeDictionary.demo.service;

import com.example.TreeDictionary.demo.Dto.EmployeeDTO;
import com.example.TreeDictionary.demo.Dto.LoginDTO;
import com.example.TreeDictionary.demo.Repo.EmployeeRepo;
import com.example.TreeDictionary.demo.Response.LoginMesage;
import com.example.TreeDictionary.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public LoginMesage addEmployee(EmployeeDTO employeeDTO) {
        Employee employee1 = employeeRepo.findByEmail(employeeDTO.getEmail());
        
        System.out.println(employeeRepo.findByEmail(employeeDTO.getEmail()));
        if (employee1 != null)
            return new LoginMesage("Email đã được đăng ký", false); 
        
        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getFirstName(),
                employeeDTO.getFirstName(),
                employeeDTO.getEmail(),

               this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return new LoginMesage("Đăng ký thành công", true);
    }
    EmployeeDTO employeeDTO;

    @Override
    public LoginMesage  loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    if (employee1.getFirstName().equals("admin"))
                        return new LoginMesage("admin", true);
                    else
                        return new LoginMesage("Đăng nhập thành công", true);
                } else {
                    return new LoginMesage("Đăng nhập thất bại", false);
                }
            } else {

                return new LoginMesage("Mật khẩu không trùng", false);
            }
        }else {
            return new LoginMesage("Email Không tồn tại", false);
        }


    }

}