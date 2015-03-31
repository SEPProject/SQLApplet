package Controller;

import MainComponents.MissionPanel;
import Model.Article;
import View.DataBasePanel;
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

    private String prez = "<html><center>Cette application a pour but de vous familiariser avec les <br> injections SQL qui se cachent derriére de nombreux formulaires.  <br>  A commencer par tous les sites ou vous vous connectez pour pouvoir accéder à certaines ressources ! </center></html>";
    EsitePanel eSite;
    DataBasePanel dbp;
    MissionPanel missionPanel;
    JPanel panelGeneral;
    private boolean appletInitialized = false;

    public void paint (Graphics g) {
        if(!appletInitialized){
            panelGeneral.repaint();
        }else{
            eSite.repaint();
            dbp.repaint();
            missionPanel.getPannelFrame().repaint();
        }

    }

    // Méthode appelée par le navigateur lorsque l'applet ne sert plus, pour libérer les ressources.
    public void destroy(){
        super.destroy();
    }

    // Méthode appelée par le navigateur lorsque l'applet est chargée.
    public void init(){
        super.init();

        panelGeneral = new JPanel(new GridLayout(2,1));
        JLabel presentation = new JLabel(prez);
        presentation.setPreferredSize(new Dimension(400,75));
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

        appletInitialized = true;

        this.setLayout(new GridLayout(1, 3));

        /*
        TEST THE ESITE PANEL
         */

        Article art1 = new Article(1,125,"KIPSTA","Parfaite pour le sport en intérieur");
        Article art2 = new Article(2,12,"NIKE","Trés utile lors de mauvais temps");
        Article art3 = new Article(3,15,"ADIDAS","Efficace sur un terrain en herbe");
        ArrayList<Article> myArts = new ArrayList<Article>();
        myArts.add(art1);
        myArts.add(art2);
        myArts.add(art3);

        SQLMissionPanel mpSQL = new SQLMissionPanel();
        eSite = new EsitePanel(myArts);
        dbp = new DataBasePanel(myArts);
        missionPanel = mpSQL.getSQLMissionPanel();

        this.add(dbp);
        this.add(eSite);
        this.add(missionPanel.getPannelFrame());

        this.revalidate();
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
