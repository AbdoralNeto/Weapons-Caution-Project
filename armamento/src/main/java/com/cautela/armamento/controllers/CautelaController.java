package com.cautela.armamento.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cautela.armamento.dto.CautelaDto;
import com.cautela.armamento.models.Cautela;
import com.cautela.armamento.models.ModelArma;
import com.cautela.armamento.models.StatusCautela;
import com.cautela.armamento.repositories.CautelaRepository;

@Controller
public class CautelaController {

    @Autowired
    private CautelaRepository cautelaRepository;

    @GetMapping("/cautelas")
    public ModelAndView cautelas() {
        List<Cautela> cautelas = this.cautelaRepository.findAll();
        ModelAndView mv = new ModelAndView("cautelas/cautelas");
        mv.addObject("cautelas", cautelas);

        return mv;
    }

    @GetMapping("/index")
    public ModelAndView novaCautela() {
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("modelArma", ModelArma.values());
        mv.addObject("statusCautela", StatusCautela.values());
        return mv;
    }

    @PostMapping("/cautelas")
    public ModelAndView create(@Valid CautelaDto requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("/index");
            mv.addObject("modelArma", ModelArma.values()); // Chama o enum na View
            mv.addObject("statusCautela", StatusCautela.values());
            return mv;

        } else {
            Cautela cautela = requisicao.toCautela();
            this.cautelaRepository.save(cautela);
            return new ModelAndView("redirect:/cautelas");

        }

    }

}