package View;

import Model.Article;
import Model.DataBaseManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 15/03/2015.
 */

public class DataBasePanel extends Panel {

    private JPanel dbPanel;
    private DataBaseManager dbm;

    private String nameCol = "Name";
    private String descCol = "Description";
    private String idCol = "Id";
    private String prixCol = "Prix";

    public DataBasePanel(ArrayList<Article> articles){

        this.dbm = new DataBaseManager(articles);

        JLabel baseTitle = new JLabel("article_table");

        this.add(baseTitle);
        this.add(createDatabasePanel(articles));
        this.add(createVerificationPanel());
    }



    private JPanel createDatabasePanel(ArrayList<Article> articles){
        dbPanel = new JPanel(new GridLayout(articles.size(),4));
        JLabel labelName = new JLabel(nameCol);
        JLabel labelDesc = new JLabel(descCol);
        JLabel labelId = new JLabel(idCol);
        JLabel labelPrix = new JLabel(prixCol);

        dbPanel.add(labelName);
        dbPanel.add(labelDesc);
        dbPanel.add(labelId);
        dbPanel.add(labelPrix);

        for(int i = 0;i<articles.size();i++){
            JLabel labelNameArt = new JLabel(articles.get(i).getName());
            JLabel labelDescArt = new JLabel(articles.get(i).getDescription());
            JLabel labelIdArt = new JLabel(String.valueOf(articles.get(i).getId()));
            JLabel labelPrixArt = new JLabel(String.valueOf(articles.get(i).getPrice()));
            dbPanel.add(labelNameArt);
            dbPanel.add(labelDescArt);
            dbPanel.add(labelIdArt);
            dbPanel.add(labelPrixArt);
        }

        return dbPanel;
    }

    private void addArticleToBase(Article article){
        this.dbm.addArticle(article);
        JLabel labelNameArt = new JLabel(article.getName());
        JLabel labelDescArt = new JLabel(article.getDescription());
        JLabel labelIdArt = new JLabel(String.valueOf(article.getId()));
        JLabel labelPrixArt = new JLabel(String.valueOf(article.getPrice()));
        dbPanel.add(labelNameArt);
        dbPanel.add(labelDescArt);
        dbPanel.add(labelIdArt);
        dbPanel.add(labelPrixArt);
    }

    private JPanel createVerificationPanel(){
        JPanel toReturn = new JPanel();
        JTextArea requestToTest = new JTextArea();
        requestToTest.setPreferredSize(new Dimension(300,25));

        JButton validerRequest = new JButton("Valider requête");
        JButton validerError = new JButton("Valider error");

        toReturn.add(requestToTest);
        toReturn.add(validerRequest);
        toReturn.add(validerError);

        return toReturn;
    }


}
