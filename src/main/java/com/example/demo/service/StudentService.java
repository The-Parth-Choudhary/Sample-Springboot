package com.example.demo.service;

import com.example.demo.model.StudentDataModel;
import com.example.demo.repoistory.StudentData;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    public StudentData studentDataRepo;

    public String createStudent(final String name, final String age, final String adhar, final String university) {
        String randomId = UUID.randomUUID().toString();
        StudentDataModel studentDataModel =  studentDataRepo.createStudent(randomId, name, age, adhar, university);
        return studentDataModel.getId();
    }

    public StudentDataModel getStudent(final String id) throws BadRequestException {
        StudentDataModel studentDataModel = studentDataRepo.getStudentById(id);

        if(studentDataModel == null) {
            throw new BadRequestException("Invalid User");
        }

        return studentDataModel;
    }
}
