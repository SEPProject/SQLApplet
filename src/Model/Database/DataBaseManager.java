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
        try {
             statement.executeUpdate("DELETE FROM articles");
            for(int i = 0;i<this.articles.size();i++){
                statement.executeUpdate("INSERT INTO articles VALUES ("+this.articles.get(i).getId()+","+
                        this.articles.get(i).getPrice()+",'"+
                        this.articles.get(i).getName()+"','"+
                        this.articles.get(i).getDescription()+"')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Article> getOriginalArticles(){
        return this.originalArticles;
    }

    public SQLErrorGenerator execQuery(String query){
        try {
             statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();//query problem on a une erreur
            return new SQLErrorGenerator(e);
        }
        return new SQLErrorGenerator();
    }

    public void majDataBase(){
        this.articles = new ArrayList<Article>();
        try {
            ResultSet resultatQuery = statement.executeQuery("SELECT * INTO articles");
            boolean rowExist = resultatQuery.first();
            while(rowExist){
                this.articles.add(new Article(resultatQuery.getInt("id"),
                        resultatQuery.getInt("prix"),
                        resultatQuery.getString("nom"),
                        resultatQuery.getString("description")));
                rowExist = resultatQuery.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();//query problem on a une erreur
        }
    }

}
