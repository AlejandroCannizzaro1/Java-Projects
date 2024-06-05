package View;

public class ViewGeneral {
    public static void sleep (String string, Integer cantidadMiliSegundos ) {
        try {
            System.out.println(string);
            Thread.sleep(cantidadMiliSegundos);
        } catch (InterruptedException e){
            System.out.println("Printea rastro de la excepcion !! ");
            e.printStackTrace();

        }
    }
}
