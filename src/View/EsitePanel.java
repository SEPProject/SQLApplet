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

        this.setLayout(new GridLayout(1,2));

        this.add(articlePanel);
        this.add(createPanierPanel());

    }

    private Panel createArticlePanel(Article article){
        Panel toReturn = new Panel(new GridBagLayout());
        JLabel price = new JLabel(String.valueOf(article.getPrice()+"€"));
        JLabel id = new JLabel(String.valueOf("Numéro : "+article.getId()));
        JLabel name = new JLabel(article.getName());
        JLabel description = new JLabel(article.getDescription());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        toReturn.add(name,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        toReturn.add(price,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        toReturn.add(description,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        toReturn.add(id,c);

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
