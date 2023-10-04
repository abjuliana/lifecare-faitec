package br.fai.lds.frontendspringlds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responsavel")
public class ResponsavelController {

    @GetMapping("/home")
    public String getCuidadorPage() {
        return "/responsavel/main";
    }


}