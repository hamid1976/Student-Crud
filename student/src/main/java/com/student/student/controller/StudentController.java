package com.student.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.student.entities.Student;
import com.student.student.services.StudentService;

@RestController
public class StudentController {
     @Autowired
    private StudentService studentService;

     //get all books handler
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){

       List<Student>list= this.studentService.getAllStudents();

       if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
       }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }//get all books

    //get single book handler
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")int id){
        Student student= studentService.getStudentById(id);
        if(student==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }//get single student by id

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){

        Student b=null;
       try {
         b=this.studentService.addStudent(student);
        System.out.println(student);
        return ResponseEntity.of(Optional.of(b));
       } catch (Exception e) {
        e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
       
    }//end addStudent

    //delete book handler
    @DeleteMapping("/students/{studentid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentid")int studentId){

        try {
             this.studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }//deleteStudent

     //update the book
     @PutMapping("/students/{studentId}")
     public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable
     ("studentId")int studentId){

        try {
             this.studentService.updateStudent(student, studentId);
             return ResponseEntity.ok().body(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
           
     }//end updateStudent


}
