package Model;

import java.util.ArrayList;

/**
 * Created by julescantegril on 16/03/2015.
 */
public class DataBaseManager {
    private ArrayList<Article> articles;
    private ArrayList<Article> originalArticles;

    public DataBaseManager(ArrayList<Article> articles){
        this.articles = articles;
        this.originalArticles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);

    }

    public ArrayList<Article> getArticles(){
        return this.articles;
    }

    public void resetDb(){
        this.articles = originalArticles;
    }

    public ArrayList<Article> getOriginalArticles(){
        return this.originalArticles;
    }



}
