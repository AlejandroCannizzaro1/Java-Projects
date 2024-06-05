package Controller;

import Interfaces.IController;
import Model.Entities.Libro;
import Model.Repositories.RepositorioLibro;
import View.ViewLibro;
import View.ViewMessages;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class ControllerLibro implements IController {
    private RepositorioLibro repositorioLibro;
    private ViewLibro viewLibro;

    public ControllerLibro(RepositorioLibro repositorioLibro, ViewLibro viewLibro) {
        this.repositorioLibro = repositorioLibro;
        this.viewLibro = viewLibro;
    }

    public void crearController() {
        this.registrarController((Libro) viewLibro.crearObject());
        System.out.println("\nLibro registado con exito !! \n");
    }

    public void registrarController(Object object) {
        this.repositorioLibro.registar((Libro) object);
    }

    public void eliminarController() {
        Integer id = viewLibro.askForIdToRemove();
        Libro libro = (Libro) this.repositorioLibro.consultar(id);
        if (libro != null){
            this.repositorioLibro.eliminar(id);
            ViewMessages.okRemovingMessage( " libro ");
        } else {
            System.out.println("\nEl libro no existe !! ");
        }
    }

    public void mostrarListController() {
        Integer i = 1 ;
        System.out.println("\nMuestra lista de libros\n");
        ArrayList<Libro> listLibro = this.repositorioLibro.getListLibros();
        if (!listLibro.isEmpty()){
            for (Libro l : listLibro){
                System.out.println("--------------------------------------------------------");
                System.out.println(i+"-");
                System.out.println(l.toString());
                System.out.println("--------------------------------------------------------");
                i++;
            }
        } else {
            System.out.println("\nLa lista de libros esta vacia !! \n ");
        }
    }
   public void actualizarControllerDisponibilidadLibro (Libro libro){
        this.repositorioLibro.actualizar(libro.getId(), libro);
   }
    public void actualizarController() {

            Integer id = viewLibro.askForIdToUpdate();
            Libro libro = (Libro) this.repositorioLibro.consultar(id);
            Integer opcion = -1;
            if (libro != null) {
                opcion = viewLibro.actualizarMenuObject();
                switch (opcion) {
                    case 1:
                        String name = viewLibro.askForData(" nuevo titulo  ");
                        libro.setTitulo(name);
                        break;
                    case 2:
                        String genero = viewLibro.askForData(" nuevo genero  ");
                        libro.setGenero(genero);
                        break;
                    case 3:
                        String autor = viewLibro.askForData(" nuevo autor  ");
                        libro.setAutor(autor);
                        break;
                    case 4:
                        Integer cantidadDeCopias = viewLibro.askForInteger(" la nueva cantidad de copias ");
                        libro.setCantidadDeCopias(cantidadDeCopias);
                        break;

                    default:
                        System.out.println("No chances to be here !! ");
                        break;
                }
                this.repositorioLibro.actualizar(id, libro);
                ViewMessages.okUpdatingMessage(" libro ");
            } else {
                System.out.println("\n El libro que quiere actualizar no existe !! \n");

            }
        }
    }

