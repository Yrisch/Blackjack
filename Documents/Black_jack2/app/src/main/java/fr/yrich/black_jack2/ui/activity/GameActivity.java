package fr.yrich.black_jack2.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.yrich.black_jack2.R;
import fr.yrich.black_jack2.data.Player;
import fr.yrich.black_jack2.fc.LogicGame;

//envoyer à alexandrerocchi38430@gmail.com

public class GameActivity extends AppCompatActivity {
    private ImageButton piocheBtn;
    private Button couche;
    private TextView miseBourse;
    private SeekBar mise;
    private TextView mainText;
    private GameActivity activity;


    private LogicGame gameInstance;
    private Player currentPlayer;
    private ArrayList<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); --> manifest
        this.couche = findViewById(R.id.coucheBtn);
        this.piocheBtn = findViewById(R.id.pioche);
        this.miseBourse = findViewById(R.id.text_bourse);
        this.mise = findViewById(R.id.mis_bar);
        this.mainText = findViewById(R.id.textMain);


        players = getIntent()
                .getExtras()
                .getParcelableArrayList(InitActivity.PLAYERS_LIST);


        // set up logic
        LogicGame game = new LogicGame();
        if (players.size() > 2)
            game.init(players);
        else
            Toast.makeText(this, "TO DO " +players.size(), Toast.LENGTH_SHORT).show();


//        names = new ArrayList<>();
//        bourses = new ArrayList<>();
//        names = Initgame.getStringArrayListExtra("names");
//        bourses = Initgame.getIntegerArrayListExtra("bourses");

//        gameInstance = new LogicGame();
//        gameInstance.init(names, bourses);

        // 1 - display player infos
        // TODO: 1/22/19
        // 2 - let player play
        // TODO: 1/22/19
        // 3 - listen to events
        // TODO: 1/22/19
        // 4 - retrieve player input
        // TODO: 1/22/19
        // 5 - send to logic
        // TODO: 1/22/19

//        currentPlayer = gameInstance.getCurrentPlayer();
//        mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
//        miseBourse.setText(String.valueOf(currentPlayer.getMoney()));
//        mise.setProgress(currentPlayer.getMoney());
//        piocheBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currentPlayer.setMise(mise.getProgress());
//                gameInstance.setPot(currentPlayer.mise);
//                currentPlayer.getMain().add(gameInstance.piocheMain.getCardinDeck());
//                gameInstance.checkScore(currentPlayer);
//                if (gameInstance.getJoueurs().size() == 0) {
//                    activity.fin_de_jeu();
//                } else {
//                    gameInstance.increaseIndex();
//                    currentPlayer = gameInstance.getCurrentPlayer();
//                    mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
//                    miseBourse.setText(String.valueOf(currentPlayer.getMoney()));
//                    mise.setProgress(currentPlayer.getMoney());
//                }
//
//            }
//        });

        // TODO: 1/22/19  
//        couche.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gameInstance.getJoueurs().remove(gameInstance.getIndexCurrentPlayer());
//                gameInstance.getStopJoueurs().add(currentPlayer);
//                if (gameInstance.getJoueurs().size() == 0) {
//                    activity.fin_de_jeu();
//                } else {
//
//                    gameInstance.increaseIndex();
//                    currentPlayer = gameInstance.getCurrentPlayer();
//                    mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
//                    miseBourse.setText(String.valueOf(currentPlayer.getMoney()));
//                    mise.setProgress(currentPlayer.getMoney());
//                }
//
//            }
//        });


    }

//
//    private void fin_de_jeu() {
//        final CustomPopup custompopup = new CustomPopup(this);
//        custompopup.settitle("Le grand Vainqueur est :" + gameInstance.getGagnant());
//        custompopup.setsubtitle("Continuer");
//        custompopup.getYesBtn().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gameAct = new Intent(getApplicationContext(), GameActivity.class);
//                gameAct.putStringArrayListExtra("names", names);
//
//                for (int i = 0; i < gameInstance.nbJoueur; i++) {
//                    Integer bou = gameInstance.getStopJoueurs().get(i).getMoney();
//                    bourses.set(i, bou);
//                }
//                gameAct.putIntegerArrayListExtra("bourses", bourses);
//                startActivity(gameAct);
//                finish();
//            }
//        });
//        custompopup.getNoBtn().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent MainAct = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(MainAct);
//                finish();
//            }
//        });
//
//        custompopup.show();
//    }
}
