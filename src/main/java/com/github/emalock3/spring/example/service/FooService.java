package com.github.emalock3.spring.example.service;

import com.github.emalock3.spring.example.domain.Employee;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {
  
  private final FooConfiguration fooConfig;
  
  @Autowired
  public FooService(FooConfiguration fooConfig) {
    this.fooConfig = fooConfig;
  }
  
  public String hello(String name) {
    return String.format(
            "Hello, %s, %s!", fooConfig.getName(), name);
  }
  
  public String configToStr() {
    return fooConfig.toString();
  }
  
  public Optional<Employee> findEmployee(Long id) {
    return (id == null || id < 0) ? Optional.empty() : 
            Optional.of(new Employee(id, String.format("name-%d", id), 
                    (int) (id % 40 + 25)));
  }
  
  public List<Employee> genRandomEmployees(int minAge) {
    Random r = new Random();
    return r.longs(r.nextInt(100))
            .mapToObj(l -> findEmployee(l))
            .filter(opt -> opt.isPresent())
            .map(opt -> opt.get())
            .filter(e -> e.getAge() > minAge)
            .collect(Collectors.toList());
  }
}
