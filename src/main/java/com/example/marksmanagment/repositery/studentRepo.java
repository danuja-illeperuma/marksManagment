package com.example.marksmanagment.repositery;

import com.example.marksmanagment.entity.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<studentEntity,String> {




}
