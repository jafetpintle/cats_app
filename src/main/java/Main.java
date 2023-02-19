import Service.CatService;
import io.github.cdimascio.dotenv.Dotenv;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        String[] botones = {"1. Get cats", "2. salir"};

        do {

            String opcion = (String) JOptionPane.showInputDialog(null, "Cats APPA", "Menu", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            switch (opcion) {
                case"1. Get cats" :
                    CatService.getCats();
                    continue;
                case"2. salir":
                    flag = false;
                    break;
                default:
            }

        } while (flag);
    }

}
