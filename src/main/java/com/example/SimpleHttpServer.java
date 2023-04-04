package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SimpleHttpServer {

  public static void main(String[] args) {
    SpringApplication.run(SimpleHttpServer.class, args);
  }

  @Controller
  public static class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
      return "Hello, world!";
    }

  }

  @Controller
  public static class LoginPageController {

    @GetMapping("/login")
    public String showLoginPage() {
      return "templates/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
      if ("user1".equals(username) && "password1".equals(password)) {
        return "redirect:/";
      } else if ("user2".equals(username) && "password2".equals(password)) {
        return "redirect:/";
      } else {
        return "redirect:/login?error";
      }
    }

  }

  @Configuration
  public static class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("forward:/index.html");
    }

  }

}
