package com.example.marksmanagment.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "marksdata", uniqueConstraints = {@UniqueConstraint(columnNames = {"reg_no","subject_code"})})
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
    private Double midMarks;
    private Double endMarks;
    private String subjectName;
    private String subjectCode;



    //calculate marks

    @Transient
    public Double getTotalMarks(){

        double q1 = Quiz01;
        double q2 = Quiz02;
        double q3 = Quiz03;

        // FIND LOWEST QUIZ

        double lowest =
                Math.min(q1, Math.min(q2, q3));

        // BEST TWO TOTAL

        double bestTwo =
                q1 + q2 + q3 - lowest;

        // BEST TWO AVERAGE

        double bestTwoAverage =
                bestTwo / 2;

        return
                (bestTwoAverage * 0.10)
                        + (midMarks * 0.20)
                        + (endMarks * 0.70);
    }


    @Transient
    public String getGrade(){

        double total = getTotalMarks();

        if(total >= 75){
            return "A";
        }
        else if(total >= 65){
            return "B";
        }
        else if(total >= 55){
            return "C";
        }
        else if(total >= 45){
            return "S";
        }
        else{
            return "F";
        }
    }







}
