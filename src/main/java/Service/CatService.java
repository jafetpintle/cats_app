package Service;

import com.google.gson.Gson;
import com.model.Cat;
import com.squareup.okhttp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class CatService {
    public static void getCats() throws IOException {
        Cat cat = null;
        //Gettin cats from API
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/images/search")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();


            //Getting json and cutting []
            String cJson = response.body().string();
            cJson = cJson.substring(1, cJson.length()-1);

            //Making a cat from the Gson class
            Gson gson = new Gson();
            cat = gson.fromJson(cJson, Cat.class);

            //Resizing image
            Image image = null;
            try{
                URL url = new URL(cat.getUrl());
                HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
                httpcon.addRequestProperty("User-Agent", "");
                BufferedImage bufferedImage = ImageIO.read(httpcon.getInputStream());

                ImageIcon catBackground = new ImageIcon(bufferedImage);

                if(catBackground.getIconWidth() > 800){
                    //Resizing
                    Image background = catBackground.getImage();
                    Image rezised = background.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                    catBackground = new ImageIcon(rezised);
                }
                String menu = "Optiones : "
                        +"1. Other cat\n"
                        +"2. Favourit\n"
                        +"3. Exit";

                String[] buttons = {"Ohter cat", "Favourite", "Exit"};
                String id_cat = cat.getId();

                String option = (String) JOptionPane.showInputDialog(null,menu,id_cat, JOptionPane.INFORMATION_MESSAGE, catBackground, buttons, buttons[0]);

                switch (option){
                    case "Ohter cat":
                        getCats();
                        break;
                    case "Favourite":

                    default:
                        break;

                }
            }catch (IOException e){
                System.out.println(e);
            }
            
    }

    private void favourite(){
        
    }
}
