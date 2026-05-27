package com.example.marksmanagment.service;

import com.example.marksmanagment.entity.deleteMarksEntity;
import com.example.marksmanagment.entity.deleteStudentEntity;
import com.example.marksmanagment.entity.marksEntity;
import com.example.marksmanagment.entity.studentEntity;
import com.example.marksmanagment.repositery.deleteMarksRepo;
import com.example.marksmanagment.repositery.deleteStudentRepo;
import com.example.marksmanagment.repositery.marksRepo;
import com.example.marksmanagment.repositery.studentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepo studentRepo;

    @Autowired
    private marksRepo marksRepo;

    @Autowired
    private deleteMarksRepo deleteMarksRepo;

    @Autowired
    private deleteStudentRepo deleteStudentRepo;

    public void SaveStudent(studentEntity studentEntity) {
        studentRepo.save(studentEntity);
    }

    public studentEntity GetStudentByRegNo(String regNo){
        return studentRepo.findById(regNo).orElse(null);
    }

    public void updateStudent(studentEntity studentEntity) {
        studentRepo.save(studentEntity);
    }
    public boolean exists(String regNo){

        return studentRepo.existsById(regNo);

    }


    @Transactional
    public void deleteStudentByRegNo(String regNo){

        studentEntity student = studentRepo.findById(regNo).orElseThrow(()->new RuntimeException("Student not found"));



            deleteStudentEntity deleteStudent = new deleteStudentEntity();
            deleteStudent.setRegNo(student.getRegNo());
            deleteStudent.setName(student.getName());
            deleteStudent.setContact(student.getContact());
            deleteStudent.setEmail(student.getEmail());
            deleteStudent.setDob(student.getDob());

            deleteStudentRepo.save(deleteStudent);





            List<marksEntity>  marksEntities = student.getMarks(); // student.getmarks() return list of marks its return array.
            for(marksEntity marksEntity : marksEntities){

                deleteMarksEntity deleteMark = new deleteMarksEntity();

                deleteMark.setRegNo(student.getRegNo());
                deleteMark.setEnd_Marks(marksEntity.getEnd_Marks());
                deleteMark.setMid_Marks(marksEntity.getMid_Marks());
                deleteMark.setQuiz02(marksEntity.getQuiz02());
                deleteMark.setQuiz03(marksEntity.getQuiz03());
                deleteMark.setQuiz01(marksEntity.getQuiz01());
                deleteMark.setSubject_Code(marksEntity.getSubject_Code());
                deleteMark.setSubject_Name(marksEntity.getSubject_Name());

                deleteMarksRepo.save(deleteMark);



        }

        studentRepo.delete(student);






    }


}
