package fr.yrich.black_jack2.ui.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.yrich.black_jack2.R;
import fr.yrich.black_jack2.data.Player;

public class PlayerHolder extends RecyclerView.ViewHolder {

    public final View rowView;
    public final TextView labelPlayerName, labelPlayerGold;
    private Player player;

    public PlayerHolder(@NonNull View itemView) {
        super(itemView);
        this.rowView = itemView;
        this.labelPlayerName = itemView.findViewById(R.id.labelPlayerName);
        this.labelPlayerGold = itemView.findViewById(R.id.labelPlayerGold);
    }

    public void setPlayer(Player player) {
        this.player = player;
        labelPlayerName.setText(player.getName());
        labelPlayerGold.setText(String.valueOf(player.getMoney()));
    }

    public void updatePlayerGold(int newGold){
        labelPlayerGold.setText(String.valueOf(newGold));
    }
    public Player getPlayer() {
        return player;
    }
}
