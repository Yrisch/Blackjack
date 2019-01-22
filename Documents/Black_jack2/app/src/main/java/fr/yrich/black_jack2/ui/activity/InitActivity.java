package fr.yrich.black_jack2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.yrich.black_jack2.data.Player;
import fr.yrich.black_jack2.adapter.PlayersListAdapter;
import fr.yrich.black_jack2.R;

public class InitActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PLAYERS_LIST = "playersList";
    public static final String ZERO = "0";
    //    InitActivity activity;
    EditText selectname;
    NumberPicker selectbourse;
    ArrayList<String> namesinit;
    ArrayList<Integer> boursesinit;
    Integer i;
    Button vldBtn;
    Button vldJ;

    private SeekBar seekBarGold;
    private TextView editTextInputGold;
    private TextView labelPlayersCount;
    private Button actionEnterTable;
    private TextInputLayout inputLayoutPlayerName;
    private RecyclerView listPlayers;

    private ArrayList<Player> playersForTable = new ArrayList<>();
    private PlayersListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_init);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        vldBtn = (Button) findViewById(R.id.initstart);
//        selectbourse = (NumberPicker) findViewById(R.id.bourse);
//        selectname = (EditText) findViewById(R.id.input_username);
//        vldBtn = (Button) findViewById(R.id.initstart);
//        selectbourse.setMinValue(1);
//        selectbourse.setMaxValue(1000);
//        namesinit = new ArrayList<>();
//        boursesinit = new ArrayList<>();
//        vldJ = (Button) findViewById(R.id.vldJ);
//        this.activity = this; // :) this is already an activity!

        seekBarGold = findViewById(R.id.gold_seekbar);
        editTextInputGold = findViewById(R.id.input_gold);
        actionEnterTable = findViewById(R.id.action_enter_table);
        inputLayoutPlayerName = findViewById(R.id.input_new_player_name);
        listPlayers = findViewById(R.id.list_players);
        labelPlayersCount = findViewById(R.id.labelPlayersCount);

        listPlayers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listAdapter = new PlayersListAdapter(this, new PlayersListAdapter.OnListInteractionCallback() {
            @Override
            public void onPlayerClick(Player player) {
                // TODO: 1/22/19 whatever you want
                Toast.makeText(InitActivity.this, "Exemple d'une interaction avec un élément de la liste (" + player.getName() + ")", Toast.LENGTH_SHORT).show();
            }
        });
        listAdapter.setPlayers(playersForTable);
        listPlayers.setAdapter(listAdapter);

        seekBarGold.incrementProgressBy(10);
        seekBarGold.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editTextInputGold.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO: 1/21/19 faire pop de la monnaie par exemple
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // do something or nothing
            }
        });

        actionEnterTable.setOnClickListener(this);

        findViewById(R.id.initstart).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_enter_table: {
                createPlayer();
                break;
            }
            case R.id.initstart: {
                if (playersForTable.size() >= 2) {
                    Intent intent = new Intent(this, GameActivity.class);
                    intent.putExtra(PLAYERS_LIST, playersForTable);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Il faut au minimum deux joueurs.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private void createPlayer() {
        if (playersForTable.size() == 7) {
            Toast.makeText(this, "Nombre maximal de joueurs atteint.", Toast.LENGTH_SHORT).show();
            return;
        }
        String newPlayerName = inputLayoutPlayerName.getEditText().getText().toString();
        int newPlayerGold = Integer.valueOf(editTextInputGold.getText().toString());
        if (newPlayerName.equals("")) {
            Toast.makeText(this, "Blablabla pas bien il faut écrire etc", Toast.LENGTH_SHORT).show();
            // prendre le focus sur le champ nom?
            return;     // mauvaise pratique!
        }
        Player newPlayer = new Player(newPlayerName, newPlayerGold);
        playersForTable.add(newPlayer);
        listAdapter.notifyDataSetChanged();
        labelPlayersCount.setText(String.valueOf(playersForTable.size()));
        // reset fields
        resetFields();
    }

    private void resetFields() {
        inputLayoutPlayerName.getEditText().setText("");
        editTextInputGold.setText(ZERO);
        seekBarGold.setProgress(0);
    }
}
