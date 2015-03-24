package Model.Database;

import Model.Article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by julescantegril on 16/03/2015.
 */
public class DataBaseManager {
    private ArrayList<Article> articles;
    private ArrayList<Article> originalArticles;
    private Connection co;
    private Statement statement;

    public DataBaseManager(ArrayList<Article> articles){
        this.articles = articles;
        this.originalArticles = articles;
        this.co = SQLConnector.getInstance();
        try {
            this.statement = this.co.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public SQLErrorGenerator execQuery(String query){
        try {
            ResultSet resultatQuery = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();//query problem on a une erreur
            return new SQLErrorGenerator(e);
        }
        return new SQLErrorGenerator();//requête bien exécutée
    }

}
