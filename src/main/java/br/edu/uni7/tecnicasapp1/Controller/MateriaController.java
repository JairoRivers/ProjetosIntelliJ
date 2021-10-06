package br.edu.uni7.tecnicasapp1.Controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import br.edu.uni7.tecnicasapp1.repository.MateriaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView criarNovaMateria (String titulo, String autor, String conteudo, String data){
        Materia materia = new Materia (titulo, autor, conteudo, new Date());

        MateriaRespository materiaRespository = new MateriaRespository();
        materiaRespository.create((materia));

        ModelAndView modelAndView = new ModelAndView("materia");
        modelAndView.addObject("materia", materiaRespository.read());
        return modelAndView;


    }

}
