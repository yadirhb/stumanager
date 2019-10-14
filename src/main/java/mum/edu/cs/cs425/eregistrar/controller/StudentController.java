package mum.edu.cs.cs425.eregistrar.controller;

import mum.edu.cs.cs425.eregistrar.model.Student;
import mum.edu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/student/search"}, params = {"_q"})
    public ModelAndView search(@RequestParam("_q") String query) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("_q", query);
        modelAndView.addObject("students", service.findByName(query));
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping({"/student/list"})
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", service.getAllStudents());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping({"/student/edit/{studentId}"})
    public String edit(@PathVariable Integer studentId, Model model) {
        Student student = service.getById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("action", "edit");
            model.addAttribute("title", "Edit student: ");
            return "student/form";
        }
        return "student/list";
    }

    @PostMapping({"/student/edit"})
    public String edit(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = service.save(student);
        return "redirect:/student/list";
    }

    @GetMapping({"/student/new"})
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("action", "new");
        modelAndView.addObject("title", "Add new student:");
        modelAndView.setViewName("student/form");
        return modelAndView;
    }

    @PostMapping({"/student/new"})
    public String create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }

        student = service.save(student);
        return "redirect:/student/list";
    }

    @GetMapping({"/student/delete/{studentId}"})
    public String delete(@PathVariable Integer studentId, Model model) {
        service.deleteById(studentId);
        return "redirect:/student/list";
    }
}
