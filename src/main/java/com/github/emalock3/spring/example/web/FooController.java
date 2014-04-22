package com.github.emalock3.spring.example.web;

import com.github.emalock3.spring.example.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class FooController {
  private final FooService fooService;
  
  @Autowired
  public FooController(FooService fooService) {
    this.fooService = fooService;
  }
  
  @RequestMapping(value="/hello/{name}", method=RequestMethod.GET)
  public String hello(@PathVariable String name) {
    return fooService.hello(name);
  }
  
  @RequestMapping("/config")
  public String fooConfigStr() {
    return fooService.configToStr();
  }
}
