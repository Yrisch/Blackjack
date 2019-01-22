package fr.yrich.black_jack2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fr.yrich.black_jack2.R;
import fr.yrich.black_jack2.data.Player;
import fr.yrich.black_jack2.ui.holder.PlayerHolder;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayerHolder> {

    private final Context context;
    private final OnListInteractionCallback listener;

    private ArrayList<Player> players;

    public interface OnListInteractionCallback {
        void onPlayerClick(Player player);
    }

    public PlayersListAdapter(Context context, OnListInteractionCallback listener) {
        this.context = context;
        this.listener = listener;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_player, parent, false);

        return new PlayerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayerHolder playerHolder, int i) {

        playerHolder.setPlayer(players.get(i));
        playerHolder.rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPlayerClick(playerHolder.getPlayer());
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
