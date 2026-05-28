package com.example.marksmanagment.service;


import com.example.marksmanagment.entity.deleteStudentEntity;
import com.example.marksmanagment.repositery.deleteStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deleteStudentService{

    @Autowired
    private deleteStudentRepo deleteStudentRepo;


    public boolean exists(String regNo){
        return deleteStudentRepo.existsById(regNo);
    }




}
