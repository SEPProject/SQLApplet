package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by julescantegril on 17/03/2015.
 */
public class SQLConnector {

    private static boolean driverLoaded = false;

    private static String urlBase ="jdbc:mysql://localhost:8888/sql_applet_db";
    private static String utilisateur = "a";
    private static String motDePasse = "a";

    public static void chargementDriver(){
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch ( ClassNotFoundException e ) {

        }
    }

    public static Connection getInstance(){

        if (!driverLoaded){
            chargementDriver();
            driverLoaded = true;
        }

        Connection connexion = null;
        try {
            System.out.println("error ");
            connexion = DriverManager.getConnection(urlBase, utilisateur, motDePasse);
            System.out.println("no error ");
            return connexion;
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.out.println("erreur sql ");
            return null;
        } finally {
            if ( connexion != null ) {

            }else{
                System.out.println("erreur ici ");
            }
        }
    }

}