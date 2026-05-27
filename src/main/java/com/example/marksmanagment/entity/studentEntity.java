package com.example.marksmanagment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "studentdata")
public class studentEntity {
    @Id
    @Column(name = "reg_no")
    private String regNo;

    private String Name;

    private LocalDate Dob;

    private String Email;

    private String Contact;

    //One student has many marks that's why I use array to hold
    //One Student → Many Marks Rows
    //One Student object → List of Marks objects
    //using cascade if the student is deleted then other relationships belongs to students will be deleted. all the marks will be deleted
    //orphanRemoval -> If parent removed then children also removed
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<marksEntity> marks;





}
