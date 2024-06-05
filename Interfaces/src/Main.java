import Model.Entities.Abstractas.ProductoSuperClase;
import Model.Entities.Comics;
import Model.Entities.IPhone;
import Model.Entities.Libro;
import Model.Entities.TvLcd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    mostrarListCatalogo();


    }
    public static void mostrarListCatalogo () {
        double valor1 = 10000;
        double valor2 = 20000;
        double valor3 = 30000;
        double valor4 = 40000;
        double valor5 = 50000;

        ProductoSuperClase[] proyectoCatalogo = new ProductoSuperClase[30];

        proyectoCatalogo[0] = new TvLcd(3500F, valor1,
                "Intelij", 19.02F, "TvLcd");

        proyectoCatalogo[1] = new Libro(500F, valor2, LocalDate.of(2023, 02, 01), "Tolkien",
                "The Lord Of The Rings", "Pascual Editoriales", "Libro");
        proyectoCatalogo[2] = new IPhone(200F, valor2, "Apple",
                "Platinado", "2023", "IPhone");
        proyectoCatalogo[3] = new Comics(400F, valor3,
                LocalDate.of(2024, 02, 03), "Marvel",
                "Back to the Darkness", "Editorial MARVEL", "Batman", "Comic");

        System.out.println("\nMuestra elementos del array \n");
        for (int i = 0; i <proyectoCatalogo.length && proyectoCatalogo[i] != null ; i++) {
            System.out.println("---------------------------------------------------------------");
            proyectoCatalogo[i].mostrarProducto();
            System.out.println("---------------------------------------------------------------");
        }
    }
}