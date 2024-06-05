import Controller.Biblioteca;
import Controller.ControllerLibro;
import Controller.ControllerPrestamo;
import Controller.ControllerUsuario;
import Model.Repositories.RepositorioLibro;
import Model.Repositories.RepositorioPrestamo;
import Model.Repositories.RepositorioUsuario;
import View.ViewLibro;
import View.ViewPrestamo;
import View.ViewUsuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ViewUsuario viewUsuario = new ViewUsuario();
        ViewLibro viewLibro = new ViewLibro();
        ViewPrestamo viewPrestamo = new ViewPrestamo();


        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        RepositorioLibro repositorioLibro = new RepositorioLibro();
        RepositorioPrestamo repositorioPrestamo = new RepositorioPrestamo();

        ControllerUsuario controllerUsuario = new ControllerUsuario(repositorioUsuario, viewUsuario);
        ControllerLibro controllerLibro = new ControllerLibro(repositorioLibro, viewLibro);
        ControllerPrestamo controllerPrestamo = new ControllerPrestamo(repositorioPrestamo, viewPrestamo,
                repositorioLibro, repositorioUsuario, controllerLibro);

        Biblioteca biblioteca = new Biblioteca (controllerUsuario, controllerLibro, controllerPrestamo);
        biblioteca.menuPrincipal();
    }
}