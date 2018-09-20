package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;

@Controller
@RequestMapping("/home")
public class DepartmentController {

    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("test1")
    public String list(Model model) {
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        return "home/test1";
    }
    
    @RequestMapping("test2")
    public String modelControl(Model model) {
    	model.addAttribute("number", 123);
    	return "home/test2";
    }
}