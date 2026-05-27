package com.example.marksmanagment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "delete_marks_data")
@Data
public class deleteMarksEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String regNo;
    private Double Quiz01;
    private Double Quiz02;
    private Double Quiz03;
    private Double Mid_Marks;
    private Double End_Marks;
    private String Subject_Name;
    private String Subject_Code;
}
