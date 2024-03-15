package com.student.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.student.dao.StudentDao;
import com.student.student.entities.Student;


@Component
public class StudentService {
    
     @Autowired
    private StudentDao studentDao;

    //getAllStudents
    public List<Student> getAllStudents(){
         List<Student> list=(List<Student>)this.studentDao.findAll();
         return list;
    }

    //get Single book by id
    public Student getStudentById(int id){
       Student student=null;
       try{
   
           student= this.studentDao.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }

    //adding the book
    public Student addStudent(Student b){
    Student result=studentDao.save(b);
        return result;
    }


    //delete the book
    public void deleteStudent(int bid) {
      studentDao.deleteById(bid);
    }
    
   //update the book
   public void updateStudent(Student student, int bookId) {
    student.setId(bookId);
    studentDao.save(student);
   }


}
