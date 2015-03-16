package Controller;

import View.SQLMissionPanel;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by julescantegril on 10/03/2015.
 */
public class Launcher extends Applet {

    public void paint (Graphics g) {

        SQLMissionPanel mpSQL = new SQLMissionPanel();
        this.add(mpSQL.getSQLMissionPanel().getPannelFrame());


    }

}
