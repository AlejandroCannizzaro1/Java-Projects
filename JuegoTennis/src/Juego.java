import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Juego {

    public String generaPlayer() {
        ArrayList<String> estadoPlayers = new ArrayList<>(Arrays.asList("P1", "P2"));
        Integer subIndiceRandom;
        Random random = new Random();
        subIndiceRandom = random.nextInt(2);
        return estadoPlayers.get(subIndiceRandom);

    }

    public void juegoTennis() {

        ArrayList<String> estadoPlayers = new ArrayList<>(Arrays.asList(" ", " "));
        String player =  " ";
        Integer iteraciones  = 0 ;
        String estadoPlayer1 = " ";
        String estadoPlayer2 = " ";
do {
    if (iteraciones == 0) {
        iteraciones++;
        estadoPlayer1 = "Lov";
        estadoPlayer2 = "Lov";
    } else {
        estadoPlayer1 = estadoPlayers.set(0, estadoPlayer1);
        estadoPlayer2 = estadoPlayers.set(1, estadoPlayer2);
    }

// Genera P1 o P2
    player = generaPlayer();

    if (player.equalsIgnoreCase("P1")) {
        // Si van 40-0, 40-15, 40-30, y hace un punto player1, gana.
        if (estadoPlayer1.equalsIgnoreCase("40") &&
                ((estadoPlayer2.equalsIgnoreCase("Lov"))
                        || estadoPlayer2.equalsIgnoreCase("15") || estadoPlayer2.equalsIgnoreCase("30"))) {
            estadoPlayer1 = "Gano P1";
        }
        /// Si player1 es igual a love, 15 o 30, entra algun condicional

        else if (estadoPlayer1.equalsIgnoreCase("Lov")) {
            estadoPlayer1 = "15";
        } else if (estadoPlayer1.equalsIgnoreCase("15")) {
            estadoPlayer1 = "30";
        } else if (estadoPlayer1.equalsIgnoreCase("30")) {
            estadoPlayer1 = "40";
        }
        /// Fin player "Love", 15 o 30

        else if (estadoPlayer1.equalsIgnoreCase("40") &&
                (estadoPlayer2.equalsIgnoreCase("40"))) {
            estadoPlayer1 = "Ventaja P1";
        } else if (estadoPlayer1.equalsIgnoreCase("Ventaja P1") &&
                estadoPlayer2.equalsIgnoreCase("40")) {
            estadoPlayer1 = "Gano P1";

        } else if (estadoPlayer1.equalsIgnoreCase("40") &&
                estadoPlayer2.equalsIgnoreCase("Ventaja P2")) {
            estadoPlayer1 = "Deuce";
            estadoPlayer2 = "Deuce";
        } else if (estadoPlayer1.equalsIgnoreCase("Deuce")
                && estadoPlayer2.equals("Deuce")) {
            estadoPlayer1 = "Ventaja P1";
            estadoPlayer2 = "40";
        }
        estadoPlayers.set(0, estadoPlayer1);
        estadoPlayers.set(1, estadoPlayer2);
        //-----------------------------------------------------------------------
        /// Player 2
        // ----------------------------------------------------------------------
    } else if(player.equalsIgnoreCase("P2")){
        // Si van 40-0, 40-15, 40-30, y hace un punto player1, gana.
        if (estadoPlayer2.equalsIgnoreCase("40") &&
                ((estadoPlayer1.equalsIgnoreCase("Lov"))
                        || estadoPlayer1.equalsIgnoreCase("15") || estadoPlayer1.equalsIgnoreCase("30"))) {
            estadoPlayer2 = "Gano P2";
        }
        /// Si player2 es igual a love, 15 o 30, entra algun condicional

        else if (estadoPlayer2.equalsIgnoreCase("Lov")) {
            estadoPlayer2 = "15";
        } else if (estadoPlayer2.equalsIgnoreCase("15")) {
            estadoPlayer2 = "30";
        } else if (estadoPlayer2.equalsIgnoreCase("30")) {
            estadoPlayer2 = "40";
        }
        /// Fin player "Love", 15 o 30
        // Si player Love == 40

        else if (estadoPlayer2.equalsIgnoreCase("40") &&
                (estadoPlayer1.equalsIgnoreCase("40"))) {
            estadoPlayer2 = "Ventaja P2";
        } else if (estadoPlayer2.equalsIgnoreCase("Ventaja P2")
                && estadoPlayer1.equalsIgnoreCase("40")) {
            estadoPlayer2 = "Gano P2";
        } else if (estadoPlayer2.equalsIgnoreCase("40") &&
                estadoPlayer1.equalsIgnoreCase("Ventaja P1")) {
            estadoPlayer1 = "Deuce";
            estadoPlayer2 = "Deuce";
        } else if (estadoPlayer1.equalsIgnoreCase("Deuce") && estadoPlayer2.equals("Deuce")) {
            estadoPlayer2 = "Ventaja P2";
            estadoPlayer1 = "40";
        }
        estadoPlayers.set(0, estadoPlayer1);
        estadoPlayers.set(1, estadoPlayer2);
    }
    muestraResultado(estadoPlayers, player);
} while (!estadoPlayers.get(0).equalsIgnoreCase("Gano P1") && !estadoPlayers.get(1).equalsIgnoreCase("Gano P2"));
     }

     public void  muestraResultado (ArrayList<String> estadoPlayers, String player){


        if (estadoPlayers.get(0).equalsIgnoreCase("Gano P1") ||
                (estadoPlayers.get(1).equalsIgnoreCase("Gano P2"))){
             System.out.println(player + "-> Game " + player);
    } else if (estadoPlayers.get(0).equalsIgnoreCase("40") &&
        estadoPlayers.get(1).equalsIgnoreCase("40")){
            System.out.println(player + "-> Deuce");
        }
        else if (estadoPlayers.get(0).equalsIgnoreCase("Ventaja P1")) {
             System.out.println( player + "-> " + estadoPlayers.get(0));
         } else  if  (estadoPlayers.get(1).equalsIgnoreCase("Ventaja P2")){
             System.out.println( player + "-> " + estadoPlayers.get(1));
        } else if (estadoPlayers.get(0).equalsIgnoreCase("Deuce") ||
                 (estadoPlayers.get(1).equalsIgnoreCase("Deuce"))){
             System.out.println(player + "-> " + "Deuce");
         } else {
            System.out.println(player + "-> " + estadoPlayers.get(0) + "-" +estadoPlayers.get(1));
        }

     }
}