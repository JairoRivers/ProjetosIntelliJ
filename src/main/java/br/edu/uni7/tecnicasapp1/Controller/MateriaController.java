package br.edu.uni7.tecnicasapp1.Controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import br.edu.uni7.tecnicasapp1.repository.MateriaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MateriaController {

    private final MateriaRespository materiaRespository;

    @Autowired
    public MateriaController (MateriaRespository materiaRespository){
        this.materiaRespository = materiaRespository;
    }

    @RequestMapping("/materia")
    public ModelAndView ListarMaterias() {

        ModelAndView modelAndView = new ModelAndView("materia");

        MateriaRespository materiaRespository = new MateriaRespository();
        List<Materia> materias = materiaRespository.read();

        modelAndView.addObject("materias", materias);

        return modelAndView;
    }


    @RequestMapping(value = "/criarMateria", method = RequestMethod.POST)
    public ModelAndView criarNovaMateria (@RequestParam String titulo, @RequestParam String autor, @RequestParam String conteudo){
        Materia materia = new Materia (titulo, autor, conteudo, new Date());
        materiaRespository.create(materia);

        ModelAndView modelAndView = new ModelAndView("materia");
        modelAndView.addObject("materias", materiaRespository.read());
        return modelAndView;


    }

}
