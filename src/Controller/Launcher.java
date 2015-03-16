package Controller;

import Model.Article;
import View.EsitePanel;
import View.SQLMissionPanel;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 10/03/2015.
 */
public class Launcher extends Applet {

    public void paint (Graphics g) {

    }

    // Méthode appelée par le navigateur lorsque l'applet ne sert plus, pour libérer les ressources.
    public void destroy(){
        super.destroy();
    }

    // Méthode appelée par le navigateur lorsque l'applet est chargée.
    public void init(){
        super.init();
        SQLMissionPanel mpSQL = new SQLMissionPanel();
        this.setLayout(new GridLayout(1, 3));
       // this.add(mpSQL.getSQLMissionPanel().getPannelFrame());

        /*
        TEST THE ESITE PANEL
         */

        Article art1 = new Article(1,125,"Chooss","Trop belle");
        Article art2 = new Article(2,12,"Css","Tropelle");
        Article art3 = new Article(3,15,"Cho","Trop belle");
        ArrayList<Article> myArts = new ArrayList<Article>();
        myArts.add(art1);
        myArts.add(art2);
        myArts.add(art3);

        EsitePanel eSite = new EsitePanel(myArts);
        this.add(eSite);

    }

    // Change les dimensions de l'applet en fixant une nouvelle longueur et une nouvelle largeur.
    public void setSize(int width, int height){

    }

    // Méthode appelée par le navigateur pour demander l'activation de l'applet,
    public void start(){
        super.start();
    }

    // Méthode appelée par le navigateur pour demander la désactivation de l'applet,
    public void stop(){
       super.stop();
   }


}
