package Controller;

import View.SQLMissionPanel;

import java.applet.Applet;
import java.awt.*;

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
        this.add(mpSQL.getSQLMissionPanel().getPannelFrame());

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
