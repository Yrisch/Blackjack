package fr.yrich.black_jack2.fc;

import java.util.ArrayList;

import fr.yrich.black_jack2.data.Player;

public class LogicGame {

    public Pioche piocheMain;
    public int nbJoueur;
    public int indexCurrentPlayer = 0;

    public ArrayList<Player> joueurs;
    public ArrayList<Player> stop_joueurs;
    public int pot;

    public LogicGame() {
        piocheMain = new Pioche();
        joueurs = new ArrayList<>();
        stop_joueurs = new ArrayList<>();
    }


    public Player getCurrentPlayer() {
        if (this.checkJoueur()) {
            joueurs.removeAll(stop_joueurs);
            indexCurrentPlayer = 0;
        }
        return joueurs.get(indexCurrentPlayer);
    }

    public void setPot(int mise) {
        pot += mise;
    }

    public boolean checkJoueur() {
        return indexCurrentPlayer == nbJoueur - 1;
    }

    public void checkScore(Player player) {
        if (player.getScore() >= 21) {
            stop_joueurs.add(player);
        } else {
            joueurs.set(indexCurrentPlayer, player);
        }

    }

    public ArrayList<Player> getJoueurs() {
        return joueurs;
    }

    public ArrayList<Player> getStopJoueurs() {
        return stop_joueurs;
    }

    public int getIndexCurrentPlayer() {
        return indexCurrentPlayer;
    }

    public int getPot() {
        return pot;
    }

    public void increaseIndex() {
        indexCurrentPlayer++;
    }

    public String getGagnant() {
        int max = 0;
        String gagnant = "";
        for (Player player : stop_joueurs) {
            if ((max < player.getScore()) && (player.getScore() <= 21)) {
                max = player.getScore();
            }
        }
        for (Player player : stop_joueurs) {
            if (max == player.getScore()) {
                gagnant = "";
                break;
            } else {
                gagnant = "NONE";
            }
        }
        return gagnant;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public void init(ArrayList<String> names, ArrayList<Integer> bourses) {
        this.setNbJoueur(names.size());
        for (int i = 0; i < nbJoueur; i++) {
            Player player = new Player();
            player.setName(names.get(i));
            player.setMoney(bourses.get(i));
            joueurs.add(player);
        }
    }

    public void init(ArrayList<Player> players) {
        joueurs.addAll(players);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////


}
