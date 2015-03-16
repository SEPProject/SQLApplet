package View;

import Model.Article;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 15/03/2015.
 */
public class EsitePanel extends Panel {

    private ArrayList<Article> myArticles;


    public EsitePanel(ArrayList<Article> myArticles){
        this.myArticles = myArticles;
    }

}
