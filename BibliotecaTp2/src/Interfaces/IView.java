package Interfaces;

public interface IView {
     Integer askForIdToRemove ();
     Integer askForIdToUpdate ();
     Integer askForIdToConsult();
     Integer actualizarMenuObject ();
     Object crearObject ();

    String askForData (String string);
    Integer askForInteger (String string);

}
