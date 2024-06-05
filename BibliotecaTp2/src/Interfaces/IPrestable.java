package Interfaces;

import Model.Entities.Persona;
import Model.Entities.Prestamo;

public interface IPrestable {

        public void realizarPrestamo();
        public Prestamo registrarFechas (Prestamo prestamo);
        public  void permitirDevoluciones ();
}
