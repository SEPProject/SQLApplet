package View;

import MainComponents.Mission;
import MainComponents.MissionPanel;
import MainComponents.Submission;

/**
 * Created by julescantegril on 15/03/2015.
 */
public class SQLMissionPanel {
    MissionPanel mp;
    public SQLMissionPanel(){
        mp = new MissionPanel(50,30,"Missions de l'applet d'injection SQL");
        Mission mission = new Mission("Présentation","Cette mission a pour but de vous familiariser avec les requêtes SQL.");
        mission.addSubmission(new Submission("Qu'est-ce qu'une base de donnée ? ","<html>Une base de donnée n'est rien de plus qu'un tableau<br> composé de colonne et qui contient des informations.</html>"));
        mission.addSubmission(new Submission("Qu'est-ce qu'une requête ?","<html>Une requête SQL interroge la base de donnée. <br>Cette derniére renvoit les informations demandées.</html>"));
        mission.addSubmission(new Submission("Exemple de requête","SELECT nom FROM user_table WHERE telephonne = 0640565432"));
        mission.addSubmission(new Submission("Et en Français ?","Envois moi le nom de l'utilisateur ayant pour numéro de téléphonne le 0640565432"));
        mission.addSubmission(new Submission("Quel requête va-t-on utiliser ici?","<html>SELECT price FROM articles WHERE id = ? . <br> Le ? correspond à l'ID que l'on va ajouter au panier</html>"));
        mission.addSubmission(new Submission("Finalement, que va-t-on faire ?","<html>Le but de ce programme est de modifier la requête d'interrogation de la base de donnée.<br> En effet, en remplaçant le point d'intérrogation de la requête précédente par une autre requête,<br> il est possible de changer la signification de la requête.</html>"));
        mission.addSubmission(new Submission("Exemple : ","SELECT price FROM articles WHERE id = (SELECT id FROM articles WHERE price = (SELECT MIN(price) FROM articles ) "));
        mission.addSubmission(new Submission("Signification ","<html>La requête ci-dessus va tout le temps renvoyer le prix de l'article le moins cher.<br> Pour celà il suffit de remplacer le ? par les deux requêtes imbriquées qui suivent.</html>"));

        Mission mission2 = new Mission("Détection","<html>Ce n'est pas tout de vouloir changer la forme d'une requête. <br> Avant toute chose il faut savoir repérer les failles.</html>");
        mission2.addSubmission(new Submission("Un petit plus important","<html>Le rôle des guillemets dans une requête SQL est important.<br> En effet, il faut être vigilant pour savoir quand les ouvrir ou quand les fermer pour respecter la syntaxe générale d'une requête.<br> Et oui ! dés que vous ouvrez des guillements, il faut les fermer !</html>"));
        mission2.addSubmission(new Submission("La requête de test"," \' 0 OR 1 = 1 \'"));
        mission2.addSubmission(new Submission("Que fait-elle ?","<html>La requête de test rend la premiére partie de la requête inutile et va sélectionner tous les prix possibles.<br> La réponse va donc être spéciale et un message d'erreur va s'afficher.<br> En effet, le programme s'attend à recevoir un prix et la base va lui renvoyer un tableau contenant tous les prix.</html> "));
        mission2.addSubmission(new Submission("Détectez la SQL injection.",""));

        Mission mission3 = new Mission("Injection","Maintenant que vous êtes un expert en SQL injection, écrivez la requête permettant d'ajouter un article.");
        mission3.addSubmission(new Submission("Validation","Validez le format général de votre requête."));

        Mission mission4 = new Mission("Modification","Il est désormais temps d'utiliser cette faille en notre faveur.");
        mission4.addSubmission(new Submission("Un nouveau mot clé","Le mot clé UPDATE permet de modifier les valeurs dans la base par des nouvelles"));
        mission4.addSubmission(new Submission("Exemple","UPDATE articles SET price = votre_valeur WHERE id = 3"));
        mission4.addSubmission(new Submission("Ecrivez et validez la requête de modification du prix",""));

        Mission mission5 = new Mission("Achat","Simulez l'achat de l'article dont vous avez modifé le prix.");
        mission5.addSubmission(new Submission(" "," "));

        Mission mission6 = new Mission("Camouflage","Pour faire ça proprement, remettez le prix initial avant de quitter.");
        mission6.addSubmission(new Submission(" "," "));

        mp.addMission(mission);
        mp.addMission(mission2);
        mp.addMission(mission3);
        mp.addMission(mission4);
        mp.addMission(mission5);
        mp.addMission(mission6);
    }

    public MissionPanel getSQLMissionPanel(){
        return this.mp;
    }
}
