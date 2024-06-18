package Model.Repositories;
import java.util.LinkedList;
import java.util.List;
import Model.Entities.*;
public class RepositorioEstudiantes {
    private List<Estudiante> listEstudiantes;

    public List getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public RepositorioEstudiantes() {
        this.listEstudiantes = new LinkedList();

    }

    public Estudiante consultar (Integer id){
        if(!listEstudiantes.isEmpty()){
            for (Estudiante e : listEstudiantes){
                if (e.getId() == id){
                    return e;
                }
            }
        }
        return null;
    }
    public void agregarEstudiante (Estudiante estudiante){
        Estudiante estudiante1 = consultar(estudiante.getId());
        if(estudiante1 == null ){
            this.listEstudiantes.add(estudiante);
        }
    }
    public void eliminarCursoEstudiantes (Estudiante estudiante){

        if(estudiante != null && !this.listEstudiantes.isEmpty()){
            for (Estudiante e : listEstudiantes){
                if(e.getId() == estudiante.getId()){
                    listEstudiantes.remove(estudiante);
                }
            }
        }
    }
}
