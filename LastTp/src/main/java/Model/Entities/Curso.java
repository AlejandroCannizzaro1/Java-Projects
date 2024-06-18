package Model.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Curso {
    private String nameCurso;
    private String codicoCurso;
    private Integer idCurso;
    private Set<Estudiante> hashSetEstudiantes;

    public Curso(String nameCurso, String codigoCurso) {
        this.nameCurso = nameCurso;
        this.codicoCurso = codigoCurso;
        this.hashSetEstudiantes = new HashSet<>();


    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }


    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public String getCodicoCurso() {
        return codicoCurso;
    }

    public void setCodicoCurso(String codicoCurso) {
        this.codicoCurso = codicoCurso;
    }

    public Set<Estudiante> getHashSetEstudiantes() {
        return hashSetEstudiantes;
    }

    public void setHashSetEstudiantes(Set<Estudiante> hashSetEstudiantes) {
        this.hashSetEstudiantes = hashSetEstudiantes;
    }

    public boolean equals (Object object){
        if(this == object){
            return true;
        }
        if (object == null || Objects.equals(this.getClass(), object.getClass())){
            return false;
        }
        Curso curso = (Curso) object;
        return Objects.equals(this.getCodicoCurso(), curso.getCodicoCurso());
    }
    public int hashCode (){
        return Objects.hash(this.getCodicoCurso());
    }
    public String toString (){

        System.out.println("Name curso: " + nameCurso + "\nCodigo curso: " + codicoCurso +
                "\nId curso: " + idCurso);
        ArrayList<Estudiante> listEstudiantes = new ArrayList<>(this.getHashSetEstudiantes());
        System.out.println("\nEstudiantes del curso : ");
        for (Estudiante e : listEstudiantes){
            System.out.println(e.toString());
        }
        return "-----------------------------------------------------------------------";

    }
}
