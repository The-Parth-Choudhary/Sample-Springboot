package com.example.demo.resource;

import com.example.demo.model.StudentDataModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public StudentDataModel getEmployee(@PathVariable String id) throws Exception {
        return studentService.getStudent(id);
    }

    @PostMapping("/create/{name}/{age}/{adhar}/{university}")
    public String createEmployee(@PathVariable String name, @PathVariable String age, @PathVariable String adhar, @PathVariable String university) {
        return studentService.createStudent(name, age, adhar, university);
    }
}
