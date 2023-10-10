package br.fai.lds.frontendspringlds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuidador")
public class CuidadorController {

    @GetMapping("/home")
    public String getCuidadorPage() {
        return "/cuidador/main";
    }

    @GetMapping("/profile")
    public String getCuidadorPerfilPage() {
        return "/cuidador/profile";
    }

    @GetMapping("/listaridoso")
    public String getLoginPage() {
        return "/cuidador/listaridoso";
    }


}
