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


    private int WIDTH_PANIER = 150;
    private int HEIGHT_PANIER = 350;
    private int HEIGHT_DETAIL_PANIER = 250;
    private int WIDTH_ARTICLE_DET_PANEL = 300;
    private int HEIGHT_ARTICLE_DET_PANEL = 150;
    private int WIDTH_ARTICLE_PANEL = WIDTH_ARTICLE_DET_PANEL+10;
    private int HEIGHT_ARTICLE_PANEL = 600;

    public EsitePanel(ArrayList<Article> myArticles){
        this.myArticles = myArticles;

        this.articlePanel = new Panel(new GridLayout(myArticles.size(),0));

        for(int i = 0;i < myArticles.size();i++){
            this.articlePanel.add(createArticlePanel(myArticles.get(i)));
        }
        this.articlePanel.setPreferredSize(new Dimension(WIDTH_ARTICLE_PANEL,HEIGHT_ARTICLE_PANEL));

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

        toReturn.setPreferredSize(new Dimension(WIDTH_ARTICLE_DET_PANEL,HEIGHT_ARTICLE_DET_PANEL));

        return toReturn;
    }

    private Panel createPanierPanel(){
        Panel toReturn = new Panel(new GridBagLayout());
        JButton reset = new JButton("Reset");

        JPanel detailPanier = new JPanel();
        detailPanier.setBackground(Color.PINK);
        detailPanier.setPreferredSize(new Dimension(WIDTH_PANIER,HEIGHT_DETAIL_PANIER));

        JTextArea idToAdd = new JTextArea();
        idToAdd.setPreferredSize(new Dimension(70,15));
        JButton addPanier = new JButton("Ajouter");
        JLabel valeurPanier = new JLabel("Valeur du panier : 0 €");

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        toReturn.add(reset,c);

        c.gridy = 1;
        toReturn.add(detailPanier,c);
        c.gridy = 2;
        toReturn.add(idToAdd,c);
        c.gridy = 3;
        toReturn.add(addPanier,c);
        c.gridy = 4;
        toReturn.add(valeurPanier,c);

        toReturn.setPreferredSize(new Dimension(WIDTH_PANIER,HEIGHT_PANIER));

        return toReturn;
    }

    private JLabel createPanelArticleForPanier(Article article){
        JLabel toReturn = new JLabel(article.getName()+" "+String.valueOf(article.getPrice())+"€");
        return toReturn;
    }

}
