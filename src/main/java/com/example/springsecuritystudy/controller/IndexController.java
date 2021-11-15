package com.example.springsecuritystudy.controller;

import com.example.springsecuritystudy.Model.Role;
import com.example.springsecuritystudy.Model.User;
import com.example.springsecuritystudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        user.setRole(Role.USER);
        userRepository.save(user);
        String password = user.getPassword();
        String encode = bCryptPasswordEncoder.encode(password);
        user.setPassword(encode);
        return "redirect:/login";
    }

    @GetMapping("/signupProc")
    public @ResponseBody
    String signupProc() {
        return "회원 가입 완료";
    }

}
