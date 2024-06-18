package org.example;

import Model.Repositories.RepositorioCursos;
import Model.Repositories.RepositorioEstudiantes;
import View.ViewEstudiante;
import View.ViewCurso;
import Controller.ControllerPrincipal;
import Model.Repositories.GestionCursos;

public class Main {
    public static void main(String[] args) {
      ViewEstudiante viewEmpleado = new ViewEstudiante();
        ViewCurso viewProyecto = new ViewCurso();
        GestionCursos gestionProyectos = new GestionCursos();
        ControllerPrincipal gestionDeProyectosController =
                new ControllerPrincipal(
                        viewProyecto, viewEmpleado, gestionProyectos);

        gestionDeProyectosController.menuPrincipal();


    }
}
