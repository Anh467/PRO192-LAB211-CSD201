package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String student(Model m, HttpServletRequest request) {
        m.addAttribute("studentList", studentService.findAllStudent());
        return "student";
    }

    @RequestMapping(value = {"/addstudent"}, method = RequestMethod.POST)
    public String addStudent(HttpServletRequest request) {
        String name = request.getParameter("name");
        String old = request.getParameter("old");
        String className = request.getParameter("class");
        String phone = request.getParameter("phone");

        Student student = new Student();
        student.setName(name);
        student.setOld(Integer.parseInt(old));
        student.setClassName(className);
        student.setPhone(phone);
        student.setCreateDate(new Date());
        student.setCreateBy("app");

        studentService.saveStudent(student);

        return "redirect:/student";
    }
}
