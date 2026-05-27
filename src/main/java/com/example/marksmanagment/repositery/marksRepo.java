package com.example.marksmanagment.repositery;

import com.example.marksmanagment.entity.marksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface marksRepo extends JpaRepository<marksEntity,Integer> {
}
