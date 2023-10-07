package br.fai.lds.frontendspringlds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/password")
    public String getPasswordPage() {
        return "/account/password";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/account/login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "/account/register";
    }
}


