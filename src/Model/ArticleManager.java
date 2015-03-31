package Model;

import java.util.ArrayList;

/**
 * Created by julescantegril on 16/03/2015.
 */
public class ArticleManager {

    ArrayList<Article> myArticle;

    ArrayList<Article> articleInPanier;

    private int panierValue;

    public ArticleManager(ArrayList<Article> myArticle){
        this.myArticle = myArticle;
        this.articleInPanier = new ArrayList<Article>();
    }

    public void addArticle(Article article){
        this.myArticle.add(article);
    }

    public Article getArticleFromId(int y){

        for(int i = 0;i < myArticle.size(); i++){
            if(myArticle.get(i).getId() == y){
                return myArticle.get(i);
            }
        }
        return null;
    }

    public void addArticleToPanier(Article article){
        this.articleInPanier.add(article);
        panierValue = panierValue + article.getPrice();
    }

    public void removeArticleToPanier(int id){
        for(int i = 0; i<this.articleInPanier.size();i++){
            if(this.articleInPanier.get(i).getId() == id){
                panierValue = panierValue - this.articleInPanier.get(i).getPrice();
                this.articleInPanier.remove(i);
            }

        }

    }

    public int getPanierValue(){
        return this.panierValue;
    }

    public void viderPanier(){
        this.panierValue = 0;
        this.articleInPanier = new ArrayList<Article>();
    }

    public void setArticles(ArrayList<Article> artc){
        this.myArticle = artc;
    }
    
}
