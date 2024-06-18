package Controller;

import View.ViewEstudiante;
import View.ViewCurso;
import Model.Entities.Estudiante;
import Model.Entities.Curso;
import Model.Repositories.GestionCursos;
import excepciones.StringVacioException;

import java.util.Map;

public class ControllerPrincipal {

    private ViewCurso viewCurso;
    private ViewEstudiante viewEstudiante;
    private GestionCursos gestionCursos;

    public ControllerPrincipal(
            ViewCurso viewCurso, ViewEstudiante viewEstudiante,
            GestionCursos gestionCursos) {
        this.viewCurso = viewCurso;
        this.viewEstudiante = viewEstudiante;
        this.gestionCursos = gestionCursos;
    }

    public void crearCurso (){
        Integer opcion = -1;

        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Crear Curso");
        try {
        Curso curso = viewCurso.crearObject();
        curso.setIdCurso(this.gestionCursos.getLastIdProyecto());
        boolean existeCurso = gestionCursos.consultarSiExisteCursoEnMap(curso.getCodicoCurso());
        if (!existeCurso) {
            this.gestionCursos.registrar(curso);
            do{
            Estudiante estudiante = this.viewEstudiante.crearObject();
            estudiante.setId(this.gestionCursos.getLastIdEstudiante());
            boolean existe = this.gestionCursos.consultarSiExisteEstudianteEnMap(estudiante);
            if (!existe){
                this.gestionCursos.registrarEstudianteEnMap(curso.getCodicoCurso(), estudiante);
            } else {
                System.out.println("\nEl estudiante ya existe en la lista !! \n");
            }
            do {
                 opcion = viewCurso.askForInteger("\nIngrese 1 para cargar otro estudiante, " +
                        "0-para salir");
                if (opcion < 0 || opcion > 1) {
                    System.out.println("Error, reintente !!");
                }
            } while (opcion<0 || opcion>1);
            } while (opcion == 1);


        } else {
            System.out.println("\nEl codigo del curso ya existe en el mapa\n");
        }
        } catch (StringVacioException e){
            e.printStackTrace();
            e.getMessage();
        }

    }
public void mostrarCursos (){
    System.out.println("\n-----------------------------------------------------------------");
    System.out.println("\nMuestra cursos ");
    System.out.println("--------------------------------------------------------------------");

    if (!this.gestionCursos.getMapActivos().isEmpty()) {
        for (Map.Entry<String, Curso> entry : this.gestionCursos.getMapActivos().entrySet()) {
            Curso c = entry.getValue();
            System.out.println(c.toString());
        }

    } else {
        System.out.println("\nMap vacio, cargue datos !! \n");
    }
}
    public void eliminarCurso () throws StringVacioException {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Eliminar curso ");
        String codigo = viewCurso.askForData("\nIngrese el codigo del curso");
        if (codigo.equals("")){
            throw  new StringVacioException("\nNo puede ingresar String vacios !! \n");
        }
        Curso curso = this.gestionCursos.consultar(codigo);
        boolean exito = this.gestionCursos.eliminar(codigo);
        if (exito == true){
            System.out.println("\nCurso eliminado con exito !! \n");
        } else {
            System.out.println("\nEl curso no existe !! \n");
        }
    }
    public void menuPrincipal () {
        Integer opcion = -1;
        do {

            do {
                System.out.println("\n----------------------------------------------------------------");
                System.out.println("-------------------Menu Principal-------------------------------");
                System.out.println("----------------------------------------------------------------");
                System.out.println("1-Crear un curso");
                System.out.println("2-Eliminar  un curso");
                System.out.println("3-Mostrar  cursos");
                System.out.println("0-Salir del sistema");

                opcion = viewEstudiante.askForInteger("\nIngrese una opcion");
                if (opcion < 0 || opcion > 3) {
                    System.out.println("\nError, reintente !! \n");
                }
            } while (opcion < 0 || opcion > 3);

            switch (opcion) {
                case 0:
                    try {
                        System.out.println("\nGuardando datos .... Bye bye .... \n");
                        Thread.sleep(2000);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    this.crearCurso();
                    break;
                case 2:
                    try {
                        this.eliminarCurso();
                    } catch (StringVacioException e){
                        e.getMessage();
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    this.mostrarCursos();
                    break;
                default:
                    System.out.println("\nWrong option !! \n");
                    break;
            }
        } while (true);
    }

}
