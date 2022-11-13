package com.windpo.registersystem.service;

import com.windpo.registersystem.entity.Student;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 风之诗
 * @version 1.0
 */
public interface UserService {
    Map<String,Object> register(List<Student> studentList);
    void download(String message, HttpServletResponse response);
}
