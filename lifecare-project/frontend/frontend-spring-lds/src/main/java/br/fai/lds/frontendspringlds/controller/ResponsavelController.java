package br.fai.lds.frontendspringlds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responsavel")
public class ResponsavelController {

    @GetMapping("/home")
    public String getResponsavelPage() {
        return "/responsavel/main";
    }

    @GetMapping("/criar/remedios")
    public String getCriarRemediosPage() {
        return "/responsavel/criar-remedios";
    }

    @GetMapping("/editar/remedios")
    public String getEditarRemediosPage() {
        return "/responsavel/editar-remedios";
    }

    @GetMapping("/remover/remedios")
    public String getRemoverRemediosPage() {
        return "/responsavel/remover-remedios";
    }


}