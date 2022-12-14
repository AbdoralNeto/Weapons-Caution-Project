package com.cautela.armamento.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cautela.armamento.dto.CautelaDto;
import com.cautela.armamento.models.Cautela;
import com.cautela.armamento.models.ModelArma;
import com.cautela.armamento.models.StatusCautela;
import com.cautela.armamento.repositories.CautelaRepository;

@Controller
@RequestMapping(value = "/cautelas")
public class CautelaController {

    @Autowired
    private CautelaRepository cautelaRepository;

    @GetMapping("")
    public ModelAndView cautelas() {
        List<Cautela> cautelas = this.cautelaRepository.findAll();
        ModelAndView mv = new ModelAndView("cautelas/cautelas");
        mv.addObject("cautelas", cautelas);

        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView novaCautela(CautelaDto requisicao) {
        ModelAndView mv = new ModelAndView("/cautelas/cadastro");
        mv.addObject("modelArma", ModelArma.values());
        mv.addObject("statusCautela", StatusCautela.values());
        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid CautelaDto requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("/cadastro");
            mv.addObject("modelArma", ModelArma.values()); // Chama o enum na View
            mv.addObject("statusCautela", StatusCautela.values());
            return mv;

        } else {
            Cautela cautela = requisicao.toCautela();
            this.cautelaRepository.save(cautela);
            return new ModelAndView("redirect:/cautelas");

        }

    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id) {
        Optional<Cautela> optional = this.cautelaRepository.findById(id);
        if (optional.isPresent()) {
            Cautela cautela = optional.get();
            ModelAndView mv = new ModelAndView("cautelas/show");
            mv.addObject("cautela", cautela);
            return mv;

        }
        // n??o achou o ig informado na tabela
        else {

            return new ModelAndView("redirect:/cautelas");

        }

    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, CautelaDto cautelaDto){
        
        Optional<Cautela> optional = this.cautelaRepository.findById(id);
        
        if(optional.isPresent()){
            Cautela cautela = optional.get();
            cautelaDto.fromCautela(cautela);

            ModelAndView mv = new ModelAndView("cautelas/edit");
            mv.addObject("cautelaId", cautela.getId());
            return mv;
        }
        else{
            return new ModelAndView("redirect:/cautelas");
        }
        
    }

}