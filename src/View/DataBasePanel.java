package View;

import Model.Article;
import Model.Database.DataBaseManager;
import Model.Database.SQLErrorGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        this.setLayout(new GridLayout(3,1));
        this.add(baseTitle);
        this.add(createDatabasePanel(articles));
        this.add(createVerificationPanel());
    }



    private JPanel createDatabasePanel(ArrayList<Article> articles){
        dbPanel = new JPanel(new GridLayout(articles.size()+1,4));
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
        JPanel toReturn = new JPanel(new GridLayout(2,1));
        JPanel buttonsPanel = new JPanel();

        final JTextArea requestToTest = new JTextArea();
        requestToTest.setPreferredSize(new Dimension(300,25));

        JButton validerRequest = new JButton("Valider requête");
        JButton validerError = new JButton("Valider error");
        JButton resetBase = new JButton("Réinitialiser la base");

        final JLabel requestResult = new JLabel();

        validerRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SQLErrorGenerator resultRequest = dbm.execQuery(requestToTest.getText().toString());
                if(resultRequest.isGoodRequest()){
                    dbm.majDataBase();
                    requestResult.setText("Bonne requête");
                }else{
                    requestResult.setText("Mauvaise requête :"+resultRequest.getMessage());
                }
                refreshDb();
            }
        });

        validerError.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        resetBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbm.resetDb();
                repaintDb();
            }
        });

        buttonsPanel.add(validerRequest);
        buttonsPanel.add(validerError);
        buttonsPanel.add(resetBase);

        toReturn.add(requestToTest);
        toReturn.add(buttonsPanel);

        return toReturn;
    }

    private void repaintDb(){
        JLabel baseTitle = new JLabel("article_table");

        this.setLayout(new GridLayout(3,1));
        this.add(baseTitle);
        this.add(createDatabasePanel(dbm.getOriginalArticles()));
        this.add(createVerificationPanel());
    }

    private void refreshDb(){
        JLabel baseTitle = new JLabel("article_table");

        this.setLayout(new GridLayout(3,1));
        this.add(baseTitle);
        this.add(createDatabasePanel(dbm.getArticles()));
        this.add(createVerificationPanel());
    }

}
