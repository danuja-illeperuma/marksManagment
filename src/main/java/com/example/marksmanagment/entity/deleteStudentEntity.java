package com.example.marksmanagment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "delete_student_data")
public class deleteStudentEntity {

    @Id
    private String regNo;

    private String Name;

    private LocalDate Dob;

    private String Email;

    private String Contact;









}
