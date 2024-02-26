package com.example.demo.repoistory;

import com.example.demo.model.StudentDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentData {
    private Map<String, StudentDataModel> studentDataMap;

    public StudentData() {
        studentDataMap = new HashMap<>();
    }

    public StudentDataModel getStudentById(final String id) {
        return studentDataMap.getOrDefault(id, null);
    }
    
    public StudentDataModel createStudent(final String id, final String name, final String age, final String adhar, final String univeristyName) {
        StudentDataModel newStudentDataModel = new StudentDataModel(id, name, age, adhar, univeristyName);
        studentDataMap.put(id, newStudentDataModel);
        return newStudentDataModel;
    }

    public StudentDataModel[] getAllStudent(){
        StudentDataModel[] data = studentDataMap.values().toArray(new StudentDataModel[0]);

        return data;
    }
}
