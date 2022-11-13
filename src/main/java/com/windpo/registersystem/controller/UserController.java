package com.windpo.registersystem.controller;

import com.windpo.registersystem.entity.Student;
import com.windpo.registersystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 风之诗
 * @version 1.0
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody List<Student> studentList){
        return userService.register(studentList);
    }
    @GetMapping("/download")
    public void download(String message, HttpServletResponse response){
        userService.download(message,response);
    }
}
