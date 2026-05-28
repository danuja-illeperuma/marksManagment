package com.example.marksmanagment.controller;


import com.example.marksmanagment.entity.marksEntity;
import com.example.marksmanagment.repositery.marksRepo;
import com.example.marksmanagment.service.marksService;
import com.example.marksmanagment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class marksController {

    @Autowired
    studentService studentService;

    @Autowired
    marksService marksService;


    @Autowired
    marksRepo marksRepo;


    @GetMapping("/addmarks")
    public String addmarks(){
        return "AddMarks";
    }

    @GetMapping("/findstum")
    public String addmarks(@RequestParam String regNo, Model model) {
        if(!studentService.exists(regNo)){
            model.addAttribute("error","student doesn't exist");
            return "AddMarks";
        }
        model.addAttribute("student",studentService.GetStudentByRegNo(regNo));
        return "AddMarks";
    }

    @PostMapping("/AddMarks")
    public String addmarks(marksEntity marksEntity , @RequestParam String regNo , RedirectAttributes redirectAttributes) {

        marksEntity.setSubjectCode(marksEntity.getSubjectCode().toUpperCase().trim());

        if(marksRepo.existsByStudent_RegNoAndSubjectCode(regNo,marksEntity.getSubjectCode())){
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Marks already exist for this subject. Please update marks.");
            return "redirect:/addmarks";
        }

        try {
            marksEntity.setStudent(studentService.GetStudentByRegNo(regNo));

            marksService.saveMarks(marksEntity);
            redirectAttributes.addFlashAttribute("success","Marks saved successfully");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error","Error adding marks");
        }
        return "redirect:/addmarks";
    }

    @GetMapping("/updatemarks")
    public String updatemarks(){
        return "UpdateMarks";
    }

    @GetMapping("/findupdatemark")
    public String updatemarks(@RequestParam String regNo, @RequestParam String subjectCode, Model model) {
        if(!marksRepo.existsByStudent_RegNoAndSubjectCode(regNo,subjectCode)){
            model.addAttribute("error","Marks doesn't exist invalid input");
            return "UpdateMarks";
        }
        model.addAttribute("mark",marksRepo.findByStudent_RegNoAndSubjectCode(regNo,subjectCode));
        return "UpdateMarks";

    }

    @PostMapping("/UpdateMarks")
    public String updatemarks(marksEntity marks, RedirectAttributes redirectAttributes , @RequestParam String regNo) {



        try {
            marks.setStudent(studentService.GetStudentByRegNo(regNo));
            marksRepo.save(marks);
            redirectAttributes.addFlashAttribute("success","Marks saved successfully");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error","Error updating marks");
        }
        return "redirect:/updatemarks";




    }

    @GetMapping("/displayallmarks")
    public String displayallmarks(Model model) {
        model.addAttribute("marks",marksRepo.findAll());
        return "DisplayAllMarks";
    }

    @GetMapping("/individualmarks")
    public String individualmarks(){
        return "DisplayIndividualMarks";
    }

    @GetMapping("/IndividualMarks")
    public String individualmarks(Model model , @RequestParam String regNo) {

        if(!studentService.exists(regNo)){
            model.addAttribute("error","student doesn't exist");
            return "DisplayIndividualMarks";
        }

        model.addAttribute("student",studentService.GetStudentByRegNo(regNo));
        return "DisplayIndividualMarks";


    }







}
