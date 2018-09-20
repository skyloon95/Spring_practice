package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.dto.Professor;
import net.skhu.dto.Student;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("/c201432014")
public class ProfessorController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired ProfessorMapper professorMapper;

    @RequestMapping("list1")
    public String list(Model model) {
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("professors", professors);
        return "c201432014/list1";
    }
    
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Professor professor = professorMapper.findOneById(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("professor", professor);
        model.addAttribute("departments", departments);
        return "c201432014/edit";
    }
    
    @RequestMapping(value="list2", method=RequestMethod.GET)
    public String list2(Model model, @RequestParam("departmentId") int departmentId) {
    	List<Professor> professors = professorMapper.findByDepartmentId(departmentId);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("professors", professors);
        model.addAttribute("departments", departments);
        return "c201432014/list2";
    }
    
}