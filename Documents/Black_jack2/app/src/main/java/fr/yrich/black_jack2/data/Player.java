package fr.yrich.black_jack2.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import fr.yrich.black_jack2.fc.Pioche;

public class Player implements Parcelable {

    private String name;
    private int money;

    public ArrayList<Pioche.Carte> main;
    public int mise;
    private int score;

    public Player() {
        // default
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    protected Player(Parcel in) {
        name = in.readString();
        money = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(money);
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };


    /**
     * Jeu >
     * TODO
     */

    public void setMise(int mise) {
        this.mise = mise;
        this.money = this.money - this.mise;
    }


    public List<Pioche.Carte> getMain() {
        return this.main;
    }


    public int getScore() {
        for (Pioche.Carte card : this.getMain()) {
            score += card.getRate();
        }
        return score;
    }

}
