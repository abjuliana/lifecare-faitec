package br.fai.lds.frontendspringlds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AcountController {

    @GetMapping("/password")
    public String getPasswordPage() {
        return "/acount/password";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/acount/login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "/acount/register";
    }
}


