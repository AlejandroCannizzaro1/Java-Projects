package Interfaces;

import excepciones.StringVacioException;

public interface Iview <T> {
    // C.AC.ASK

    public T crearObject ()throws StringVacioException;


    public Integer askForInteger (String string);
    public String askForData (String string);
}
