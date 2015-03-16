package Model;

import java.util.ArrayList;

/**
 * Created by julescantegril on 16/03/2015.
 */
public class DataBaseManager {
    private ArrayList<Article> articles;

    public DataBaseManager(ArrayList<Article> articles){
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    public ArrayList<Article> getArticles(){
        return this.articles;
    }

}
