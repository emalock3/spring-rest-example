package com.github.emalock3.spring.example.service;

import java.net.InetAddress;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fooConfig")
@lombok.Data
public class FooConfiguration {
  private String name;
  private Integer foo;
  private InetAddress address;
}
