package com.example.marksmanagment.repositery;

import com.example.marksmanagment.entity.deleteMarksEntity;
import com.example.marksmanagment.entity.deleteStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface deleteStudentRepo extends JpaRepository<deleteStudentEntity,String>{
}
