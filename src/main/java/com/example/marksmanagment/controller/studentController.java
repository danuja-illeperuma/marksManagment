package com.example.marksmanagment.controller;
import com.example.marksmanagment.entity.studentEntity;
import com.example.marksmanagment.repositery.studentRepo;
import com.example.marksmanagment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class studentController {

    @Autowired
    private studentService studentService;

    @GetMapping("/Add_Student")
    public String Add_Student(){
        return "Add_Student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(studentEntity student, RedirectAttributes redirectAttributes){


        if(studentService.exists(student.getRegNo())){

            redirectAttributes.addFlashAttribute("error","Registration number already exists");
            return "redirect:/Add_Student";

        }
        try {
            studentService.SaveStudent(student);
            redirectAttributes.addFlashAttribute("success","Student has been saved successfully");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }


        return "redirect:/Add_Student";


    }


    @GetMapping("/viewstudent")
    public String viewstudent(Model model){
        model.addAttribute("searched", false);
        return "ViewStudent";
    }

    @PostMapping("/ViewStudent")
    public String viewStudent(@RequestParam String regNo, Model model){

        model.addAttribute("student",studentService.GetStudentByRegNo(regNo));
        model.addAttribute("searched", true);
        return "ViewStudent";

    }

    @GetMapping("/updateStudent")
    public String updateStudent(){
        return "UpdateStudent";
    }

    @GetMapping("/FindStudent")
    public String updateStudent(@RequestParam String regNo,Model model){

        if (!studentService.exists(regNo)){
            model.addAttribute("error","Registration number does not exist");
            return "UpdateStudent";
        }

        model.addAttribute("student",studentService.GetStudentByRegNo(regNo));
        return "UpdateStudent";

    }

    @PostMapping("UpdateStudent")
    public String updateStudent(studentEntity student,RedirectAttributes redirectAttributes){

        try {
            studentService.updateStudent(student);
            redirectAttributes.addFlashAttribute("success","Student has been updated successfully");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error",e.getMessage());

        }
        return "redirect:/updateStudent";
    }

    @GetMapping("/deletestudent")
    public String deleteStudent(){
        return "Delete_Student";
    }

    @PostMapping("/DeleteStudent")
    public String deleteStudent(@RequestParam String regNo,RedirectAttributes redirectAttributes){
        if (!studentService.exists(regNo)){
            redirectAttributes.addFlashAttribute("error","Registration number does not exist");
            return "redirect:/deletestudent";
        }
        try{
            studentService.deleteStudentByRegNo(regNo);
            redirectAttributes.addFlashAttribute("success","Student has been deleted successfully");
        }
        catch (RuntimeException e){

            redirectAttributes.addFlashAttribute(
                    "error",
                    e.getMessage());
        }
        catch (Exception e){

            redirectAttributes.addFlashAttribute(
                    "error",
                    "System error occurred");
        }
        return "redirect:/deletestudent";
    }



}
