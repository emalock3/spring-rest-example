package com.github.emalock3.spring.example.web;

import com.github.emalock3.spring.example.domain.Employee;
import com.github.emalock3.spring.example.service.FooService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmpController {
  private final FooService fooService;

  @Autowired
  public EmpController(FooService fooService) {
    this.fooService = fooService;
  }
  
  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public Employee find(@PathVariable long id) {
    return fooService.findEmployee(id).orElse(null);
  }
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Employee> list(@RequestParam(defaultValue = "20") int minAge) {
    return fooService.genRandomEmployees(minAge);
  }
}
