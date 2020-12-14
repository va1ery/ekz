package com.max.ekz.service;

import com.max.ekz.Models.Student;
import com.max.ekz.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    final
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public double countAverageMark(){
        long marksQuantity = studentRepository.count();
        List<Integer> marks = new ArrayList<>();
        Iterator<Student> iterator = studentRepository.findAll().iterator();
        while (iterator.hasNext())
            marks.add(iterator.next().getMark());
        int sum = 0;
        for (Integer mark :
                marks) {
            sum+=mark;
        }
        return sum/marksQuantity;
    }

    public List<Student> getStudentsWithBigMark(){
        double avMark = countAverageMark();
        Iterator<Student> iterator = studentRepository.findAll().iterator();
        List<Student> students = new ArrayList<>();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if((double)student.getMark() > avMark)
                students.add(student);
        }
        return students;
    }
}
