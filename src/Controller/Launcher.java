package Controller;

import MainComponents.Mission;
import MainComponents.MissionPanel;
import MainComponents.Submission;

import javax.swing.*;

/**
 * Created by julescantegril on 10/03/2015.
 */
public class Launcher {

    public static void main(String [] arg){
        MissionPanel mp = new MissionPanel("SQL Mission");
        Mission mission = new Mission("Premier mission","Premiere description");
        mission.addSubmission(new Submission("Premier sub","Premiere sub desc"));
        mission.addSubmission(new Submission("Deux sub","Deux sub desc"));
        mission.addSubmission(new Submission("Trois sub","Trois sub desc"));
        mission.addSubmission(new Submission("Quatre sub","Quatre sub desc"));

        mp.addMission(mission);
        mp.addMission(mission);
        mp.addMission(mission);

        JFrame jf = new JFrame();
        jf.setSize(500, 800);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(mp.getPannelFrame());

    }

}
