/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6110.ci6110.controllers;

import com.ci6110.ci6110.entities.Employee;
import com.ci6110.ci6110.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pk
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository EmployeeRepo;
    
    @GetMapping("/")

    public String showPage(Model model,Pageable pageable){        
        model.addAttribute("data", EmployeeRepo.findAll(pageable)); 
       
        List<Employee> employees = new ArrayList<>();
   EmployeeRepo.findAll().forEach(employees::add);
   float sum = 0;
   for (Employee e : employees) {
            sum += e.getSalary();
    }
     float average = sum / employees.size();
     String average1 = String.format("%.2f", average);
  model.addAttribute("avg", average1);
 
  Employee element = Collections.max(employees, Comparator.comparingDouble(Employee::getSalary));
  float max = element.getSalary();
  String max1 = String.format("%.2f", max);
 model.addAttribute("max", max1);
  
        return "index"; 
    }
   
    
    
    
    @PostMapping("/save")
    public String save(Employee e) {
        EmployeeRepo.save(e);
        
        return "redirect:/";
    }
    
     @GetMapping("/delete")
    public String deleteEmployee(Integer id) {
       EmployeeRepo.deleteById(id);
        
        return "redirect:/";
    } 
    
     @GetMapping("/findOne")
     @ResponseBody    
public Optional<Employee> getEmployee(Integer id) {
   
return EmployeeRepo.findById(id);       
        
    } 



//iteration 1 is below. Can be accessed by localhost:8080/addemployee

List<Employee> oneemployees = new ArrayList<>();
    
     @GetMapping("/addemployee")
    public String greetingForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addemployee";
    }
    
    @PostMapping("/result")
    public String addEmployee(Model model, @ModelAttribute Employee e) {
        String empsal = String.format("%.2f", e.getSalary());
     
       oneemployees.add(e);
        float sum = 0;
       for (Employee newe : oneemployees) {
            sum += newe.getSalary();
    }
     float average = sum / oneemployees.size();
   String average1 =  String.format("%.2f", average);
   
  
 
  Employee element = Collections.max(oneemployees, Comparator.comparingDouble(Employee::getSalary));
  float max = element.getSalary();
  String max1 =  String.format("%.2f", max);
 
 model.addAttribute("empsal", empsal);
 model.addAttribute("avg", average1); 
 model.addAttribute("max", max1);
 
 return "result"; 
    }
    
    
    
}
