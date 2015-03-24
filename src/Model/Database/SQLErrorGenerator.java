package Model.Database;

import java.sql.SQLException;

/**
 * Created by julescantegril on 17/03/2015.
 */
public class SQLErrorGenerator {

    private int tableNotExist = 1146;


    private boolean isGoodRequest;

    private String message;

    public SQLErrorGenerator(){
        this.isGoodRequest = true;
    }

    public SQLErrorGenerator(SQLException e){
        this.message = e.toString();
        this.isGoodRequest = false;
    }

    public boolean isGoodRequest() {
        return isGoodRequest;
    }

    public void setGoodRequest(boolean isGoodRequest) {
        this.isGoodRequest = isGoodRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
