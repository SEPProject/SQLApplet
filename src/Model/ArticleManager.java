package Model;

import java.util.ArrayList;

/**
 * Created by julescantegril on 16/03/2015.
 */
public class ArticleManager {

    ArrayList<Article> myArticle;

    public ArticleManager(ArrayList<Article> myArticle){
        this.myArticle = myArticle;
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

}
