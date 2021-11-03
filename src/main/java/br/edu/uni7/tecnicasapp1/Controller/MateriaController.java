package br.edu.uni7.tecnicasapp1.Controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import br.edu.uni7.tecnicasapp1.repository.MateriaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@Controller
public class MateriaController {

    private final MateriaRespository materiaRespository;

    @Autowired
    public MateriaController (MateriaRespository materiaRespository){
        this.materiaRespository = materiaRespository;
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.GET)
    public Materia encontrarMateria(@PathVariable Integer id) {
        return materiaRespository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "materia", method = RequestMethod.GET)
    public List<Materia> ListarMaterias() {
        return materiaRespository.read();
    }

    @ResponseBody
    @RequestMapping(value = "/materia", method = RequestMethod.POST)
    public Materia criarMateria (@RequestBody Materia materia){
        materia.setData(new Date());
        materiaRespository.create(materia);

        return materia;
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.DELETE)
    public void apagarMateria(@PathVariable Integer id){
        materiaRespository.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.PUT)
    public void atualizarMateria(@PathVariable Integer id, @RequestBody Materia materia){
        materiaRespository.update(id, materia);
    }
}
