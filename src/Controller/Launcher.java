package Controller;

import Model.Article;
import View.EsitePanel;
import View.SQLMissionPanel;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by julescantegril on 10/03/2015.
 */
public class Launcher extends Applet {

    private String prez = "Cette application a pour but de vous familiariser avec les injections SQL qui se cachent derriére de nombreux formulaires. A commencer par tous les sites ou vous vous connectez pour pouvoir accéder à certaines ressources !";

    public void paint (Graphics g) {

    }

    // Méthode appelée par le navigateur lorsque l'applet ne sert plus, pour libérer les ressources.
    public void destroy(){
        super.destroy();
    }

    // Méthode appelée par le navigateur lorsque l'applet est chargée.
    public void init(){
        super.init();

        JPanel panelGeneral = new JPanel(new GridLayout(2,1));
        JLabel presentation = new JLabel(prez);
        JButton commencer = new JButton("Commencer");
        commencer.setPreferredSize(new Dimension(100,75));

        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApplet();
            }
        });

        panelGeneral.add(presentation);
        panelGeneral.add(commencer);
        this.add(panelGeneral);

    }

    public void initializeApplet(){
        this.removeAll();
        SQLMissionPanel mpSQL = new SQLMissionPanel();
        this.setLayout(new GridLayout(1, 3));

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
