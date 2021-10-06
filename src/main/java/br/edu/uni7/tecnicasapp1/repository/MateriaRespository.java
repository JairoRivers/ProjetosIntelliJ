package br.edu.uni7.tecnicasapp1.repository;


import br.edu.uni7.tecnicasapp1.model.Materia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MateriaRespository {
    private List<Materia> materias;

    public MateriaRespository(){
        materias = new ArrayList<>();
    }

    public void create (Materia materia){
        materias.add(materia);
    }

    public List<Materia> read (){
        return materias;
    }

    public void update (Materia materia){
        //atualizar o objeto no BD
    }

    public void delete (Materia materia){
        //apagar o objeto no BD
    }
}
