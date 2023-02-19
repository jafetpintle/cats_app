import io.github.cdimascio.dotenv.Dotenv;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        String[] botones = {"1. ver gatos", "2. salir"};

        do {

            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu principal", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            switch (opcion) {
                case"1. ver gatos" :

                    continue;
                case"2. salir":
                    flag = false;
                    break;
                default:
            }

        } while (flag);
    }

}
