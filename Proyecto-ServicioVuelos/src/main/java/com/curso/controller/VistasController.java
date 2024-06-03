package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.service.VuelosService;

@Controller
public class VistasController {

    @Autowired
    private VuelosService vuelosService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("listar")
    public String listarVuelos(Model model) {
        model.addAttribute("vuelos", vuelosService.vuelos());
        return "listar";
    }
}
