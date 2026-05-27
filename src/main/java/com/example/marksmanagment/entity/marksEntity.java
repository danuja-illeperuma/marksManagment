package com.example.marksmanagment.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "marksdata")
public class marksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //many marks belong to one student
    @ManyToOne(fetch = FetchType.EAGER) //Immediately loads student.
    @JoinColumn(name = "reg_no")
    private studentEntity student;



    private Double Quiz01;
    private Double Quiz02;
    private Double Quiz03;
    private Double Mid_Marks;
    private Double End_Marks;
    private String Subject_Name;
    private String Subject_Code;

}
