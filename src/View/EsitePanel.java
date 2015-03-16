package View;

import Model.Article;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 15/03/2015.
 */
public class EsitePanel extends Panel {

    private ArrayList<Article> myArticles;
    private Panel articlePanel;

    public EsitePanel(ArrayList<Article> myArticles){
        this.myArticles = myArticles;

        this.articlePanel = new Panel(new GridLayout(myArticles.size()-1,1));
        for(int i = 0;i < myArticles.size();i++){
            this.articlePanel.add(createArticlePanel(myArticles.get(i)));
        }


    }

    private Panel createArticlePanel(Article article){
        Panel toReturn = new Panel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        return toReturn;
    }

    private int ELEMENT_IN_PANIER = 5;
    private Panel createPanierPanel(){
        Panel toReturn = new Panel(new GridLayout(ELEMENT_IN_PANIER,1));
        JButton reset = new JButton("Reset");
        JPanel detailPanier = new JPanel();
        JTextArea idToAdd = new JTextArea();
        JButton addPanier = new JButton("Ajouter");
        JLabel valeurPanier = new JLabel("Valeur du panier");

        toReturn.add(reset);
        toReturn.add(detailPanier);
        toReturn.add(idToAdd);
        toReturn.add(addPanier);
        toReturn.add(valeurPanier);

        return toReturn;
    }

}
