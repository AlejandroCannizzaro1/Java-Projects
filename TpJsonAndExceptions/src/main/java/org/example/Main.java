package org.example;
import Model.Entitites.Contacto;
import Model.Repositories.RepositorioContactos;
import View.ViewContacto;
import Controller.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RepositorioContactos repositorioContactos = new RepositorioContactos();
        ViewContacto viewContacto = new ViewContacto(repositorioContactos);
        ContactosController contactosController = new ContactosController(viewContacto, repositorioContactos);

        Agenda agenda = new Agenda(contactosController, viewContacto);

        agenda.menuPrincipal();
    }
}