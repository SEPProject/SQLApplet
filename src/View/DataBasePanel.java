package View;

import Model.Article;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 15/03/2015.
 */

public class DataBasePanel extends Panel {

    public DataBasePanel(){

    }

    private String nameCol = "Name";
    private String descCol = "Description";
    private String idCol = "Id";
    private String prixCol = "Prix";


    private JPanel createDatabasePanel(ArrayList<Article> articles){
        JPanel dbPanel = new JPanel(new GridLayout(articles.size(),4));
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

    private Panel createVerificationPanel(){
        return null;
    }


}
