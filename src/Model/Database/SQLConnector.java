package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by julescantegril on 17/03/2015.
 */
public class SQLConnector {

    private static boolean driverLoaded = false;

    private static String urlBase ="jdbc:mysql://localhost:8889/sql_applet_db";
    private static String utilisateur = "b";
    private static String motDePasse = "b";

    public static void chargementDriver(){
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){

        if (!driverLoaded){
            chargementDriver();
            driverLoaded = true;
        }

        Connection connexion = null;
        try {
           // System.out.println("error ");
            connexion = DriverManager.getConnection(urlBase, utilisateur, motDePasse);
            return connexion;
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.out.println("erreur sql ");
            return null;
        } finally {
            if ( connexion != null ) {
               // System.out.println("erreur la");
            }else{
                System.out.println("erreur ici ");
            }
        }
    }

}