package View;

public class ViewMessages {
    public static void   errorUpdateMessage (String string ){
        System.out.println("Error al cargar los datos del" +string+ " !! ");
    }
    public static void  okUpdatingMessage (String string ){
        System.out.println("Exito al cargar los datos del " + string+  " !! ");
    }
    public static void errorRemovingMessage (String string){
        System.out.println("Error al eliminar  los datos del " +string+  " !! ");
    }
    public static void okRemovingMessage (String string ){
        System.out.println("Exito al eliminar los datos del " + string+ "!! ");
    }
    public static void errorCreatingObjectMessage (String string){
        System.out.println("Error al crear el " + string +  " !! ");
    }
    public static void okCreatingObjectMessage (String string ){
        System.out.println("Exito al crear el " + string +  " !! ");
    }

}
