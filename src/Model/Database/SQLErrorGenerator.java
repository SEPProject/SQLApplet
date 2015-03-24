package Model.Database;

import java.sql.SQLException;

/**
 * Created by julescantegril on 17/03/2015.
 */
public class SQLErrorGenerator {

    boolean isGoodRequest;

    public SQLErrorGenerator(){
        this.isGoodRequest = true;
    }

    public SQLErrorGenerator(SQLException e){
        this.isGoodRequest = false;
    }

}
