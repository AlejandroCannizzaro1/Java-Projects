package Model.Repositories;

import Model.Entities.Curso;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import Model.Entities.*;
public class RepositorioCursos {
    private List<Curso>listCursos;

    public RepositorioCursos() {
        listCursos = new LinkedList();
    }

    public List getListCursos() {
        return listCursos;
    }

    public void setListCursos(List listCursos) {
        this.listCursos = listCursos;
    }
    public Curso consultar (Integer idCurso){
        if(!listCursos.isEmpty()){
            for (Curso c : listCursos){
                if (c.getIdCurso() == idCurso){
                    return c;
                }
            }
        }
        return null;
    }
public void agregarCurso (Curso curso){

        Curso curso1 = consultar(curso.getIdCurso());
        if(curso1 == null ){
            this.listCursos.add(curso);
        }
}
    public void eliminarCurso (Curso curso){

            if(curso != null && !this.listCursos.isEmpty()){
                   listCursos.remove(curso);
            }
    }


}
