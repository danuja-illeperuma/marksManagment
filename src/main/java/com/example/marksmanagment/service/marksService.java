package com.example.marksmanagment.service;


import com.example.marksmanagment.entity.marksEntity;
import com.example.marksmanagment.repositery.marksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class marksService {

    @Autowired
    private marksRepo marksRepo;

    public void saveMarks(marksEntity marksEntity) {
        marksRepo.save(marksEntity);
    }
}
