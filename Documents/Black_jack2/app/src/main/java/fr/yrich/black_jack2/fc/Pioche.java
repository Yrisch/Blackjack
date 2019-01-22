package fr.yrich.black_jack2.fc;

import java.util.ArrayList;
import java.util.Collections;

public class Pioche {


    public ArrayList<Carte> pioche;

    //constructeur paquet
    public Pioche() {
        this.pioche = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                Carte card = new Carte();
                card.setValues(j);
                card.setFamily(i);
                card.setRate();
                this.pioche.add(card);
            }
        }
        this.shuffle();
    }

    //méthode de pioche
    public Carte getCardinDeck() {
        final Carte cardget = this.pioche.get(0);
        this.pioche.remove(cardget);
        return cardget;
    }

    //mélange
    private void shuffle() {
        Collections.shuffle(pioche);
    }

    //objet carte
    public class Carte {

        private int values;
        private int Family;
        private int rate;
        private int[] card = {Family, values};

        //constructeur
        public Carte() {
        }

        //Accesseurs
        public void setValues(int values) {
            this.values = values;
        }

        public void setFamily(int family) {
            this.Family = family;
        }

        public int getValues() {
            return values;
        }

        public int getFamily() {
            return Family;
        }

        public int[] getCard() {
            return card;
        }

        public int getRate() {
            return rate;
        }

        public void setRate() {
            if (values >= 1 && values <= 9) {
                rate = values + 1;
            } else if (values >= 10) {
                rate = 10;
            } else {
                rate = 11
                ;
            }
        }
    }
}