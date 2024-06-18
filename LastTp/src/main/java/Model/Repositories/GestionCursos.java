package Model.Repositories;

import Interfaces.IRepositoryMap;
import Model.Entities.Curso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Model.Entities.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GestionCursos implements IRepositoryMap<String, Curso> {
    Gson gson = new Gson();
    private static final String FILE_PATH = "src/main/resources/proyectos.json";
RepositorioCursos repositorioCursos = new RepositorioCursos();
RepositorioEstudiantes repositorioEstudiantes = new RepositorioEstudiantes();
    private Map<String, Curso> mapActivos;
    private static Integer nextIdProyecto = 1;
    private static Integer nextIdEmpleado = 1;


    public static void setNextIdEmpleado(Integer nextIdEmpleado) {
        GestionCursos.nextIdEmpleado = nextIdEmpleado;
    }

    public GestionCursos() {

        this.loadCursos();

    }

    public Map<String, Curso> getMapActivos() {
        return mapActivos;
    }

    public void setMapActivos(Map<String, Curso> mapActivos) {
        this.mapActivos = mapActivos;
    }

    public void loadCursos() {
        try (Reader reader = new FileReader(FILE_PATH)){

            Type lystTipe = new TypeToken <Map<String, Curso>> (){}.getType();
            this.mapActivos = gson.fromJson(reader, lystTipe);
            if(this.mapActivos != null){
               Boolean exito =  cargarReposFromFile();
               if(exito){
                   System.out.println("\nDatos cargados en repo con exito !! \n");
               }
            }
            if (this.mapActivos == null){
                this.mapActivos = new HashMap<>();
            }
        } catch (FileNotFoundException f){
          this.mapActivos = new HashMap<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public void saveCursos () {
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(this.mapActivos, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Curso consultar (String codigo){
        if (mapActivos.containsKey(codigo)){
            return mapActivos.get(codigo);
        }
        return null;
    }
    public boolean eliminar(String key){
        boolean exito = false;
        if (mapActivos.containsKey(key)){
            this.mapActivos.remove(key);
            saveCursos();
            exito =true;
        }
        return  exito;
    }
    public Integer getLastIdProyecto (){
        Integer lastId = 0;
        if(!this.mapActivos.isEmpty()){
            for (Map.Entry<String, Curso> entry : this.mapActivos.entrySet()){
                Curso c = entry.getValue();
                if(c.getIdCurso()>lastId){
                    lastId = c.getIdCurso();
                }
            }
        }
        lastId = lastId + 1 ;
        return lastId;
    }

    public Integer getLastIdEstudiante (){
        Integer lastId = 0;
        if(!this.mapActivos.isEmpty()){
            for (Map.Entry<String, Curso> entry : this.mapActivos.entrySet()){
                Curso p = entry.getValue();
                for (Estudiante e : p.getHashSetEstudiantes()){
                    if(e.getId()>lastId){
                        lastId = e.getId();
                    }
                }
            }
        }
        lastId = lastId + 1 ;
        return lastId;
    }
    public void registrar (Curso curso){

        if (!mapActivos.containsKey(curso.getCodicoCurso())){
            mapActivos.put(curso.getCodicoCurso(), curso);
            this.saveCursos();
        }
    }


    public boolean consultarSiExisteEstudianteEnMap(Estudiante estudiante){
        if (!this.mapActivos.isEmpty()){
            for (Map.Entry<String, Curso> entry : mapActivos.entrySet()){
                Curso c = entry.getValue();
              for (Estudiante e : c.getHashSetEstudiantes()){
                  if (e.getId() == estudiante.getId() || e.getNombre().equals(estudiante.getNombre()) ){
                      return true;
                  }
              }
            }
        }
        return false;
    }

    public boolean consultarSiExisteCursoEnMap (String codigo){
        if (!this.mapActivos.isEmpty()){
           if (this.mapActivos.containsKey(codigo) ){
               return true;
                }
            }
        return false;
    }
    public void eliminarEstudianteEnMap(String codigo, Estudiante estudiante){
        if(mapActivos.containsKey(codigo)){
            Curso curso = this.mapActivos.get(codigo);
            curso.getHashSetEstudiantes().add(estudiante);
            this.saveCursos();
        }
    }
    public void registrarEstudianteEnMap(String codigo, Estudiante estudiante) {
        if (!mapActivos.isEmpty() && mapActivos.containsKey(codigo)) {
            Curso curso = mapActivos.get(codigo);
            if (!curso.getHashSetEstudiantes().contains(estudiante)) {
                curso.getHashSetEstudiantes().add(estudiante);
                this.saveCursos();
            }
        }
    }
    public boolean cargarReposFromFile (){
        if(!this.mapActivos.isEmpty()){
            for (Map.Entry<String, Curso> entry : this.mapActivos.entrySet()){
                Curso curso = entry.getValue();
                this.repositorioCursos.agregarCurso(curso);
                for (Estudiante e : curso.getHashSetEstudiantes()){
                    this.repositorioEstudiantes.agregarEstudiante(e);
                }
                return true;
            }
        }
        return  false;
    }
}
