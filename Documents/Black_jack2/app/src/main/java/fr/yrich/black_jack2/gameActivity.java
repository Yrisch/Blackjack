package fr.yrich.black_jack2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

//envoyer à alexandrerocchi38430@gmail.com

public class gameActivity extends AppCompatActivity {
    private ImageButton piocheBtn;
    private Button couche;
    private TextView miseBourse;
    private SeekBar mise ;
    private TextView mainText;
    private gameActivity activity;



    private ArrayList<String> names;
    private ArrayList<Integer> bourses;
    private Logic_game gameInstance;
    private Logic_game.Joueur currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.couche =  findViewById(R.id.coucheBtn);
        this.piocheBtn =  findViewById(R.id.pioche);
        this.miseBourse = findViewById(R.id.text_bourse);
        this.mise =  findViewById(R.id.mis_bar);
        Intent Initgame = getIntent();
        mainText = findViewById(R.id.textMain);
        names = new ArrayList<>();
        bourses = new ArrayList<>();
        names = Initgame.getStringArrayListExtra("names");
        bourses = Initgame.getIntegerArrayListExtra("bourses");
        gameInstance = new Logic_game();
        gameInstance.init(names,bourses);
        this.activity=this;


        currentPlayer = gameInstance.getCurrentPlayer();
        mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
        miseBourse.setText(currentPlayer.getBourse().toString());
        mise.setProgress(currentPlayer.getBourse());
        piocheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayer.setMise(mise.getProgress());
                gameInstance.setPot(currentPlayer.mise);
                currentPlayer.getMain().add(gameInstance.piocheMain.getCardinDeck());
                gameInstance.checkScore(currentPlayer);
                if (gameInstance.getJoueurs().size()==0){
                    activity.fin_de_jeu();
                }
                else{
                    gameInstance.increaseIndex();
                    currentPlayer = gameInstance.getCurrentPlayer();
                    mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
                    miseBourse.setText(currentPlayer.getBourse().toString());
                    mise.setProgress(currentPlayer.getBourse());
                }

            }
        });
        couche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInstance.getJoueurs().remove(gameInstance.getIndexCurrentPlayer());
                gameInstance.getStopJoueurs().add(currentPlayer);
                if (gameInstance.getJoueurs().size()==0){
                    activity.fin_de_jeu();
                }
                else{

                    gameInstance.increaseIndex();
                    currentPlayer = gameInstance.getCurrentPlayer();
                    mainText.setText(String.format("joueur : " + currentPlayer.getName() + "  Score :" + currentPlayer.getScore()));
                    miseBourse.setText(currentPlayer.getBourse().toString());
                    mise.setProgress(currentPlayer.getBourse());
                }

            }
        });





    }



    private void fin_de_jeu() {
        final CustomPopup custompopup= new CustomPopup(this);
        custompopup.settitle("Le grand Vainqueur est :"+gameInstance.getGagnant());
        custompopup.setsubtitle("Continuer");
        custompopup.getYesBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameAct = new Intent(getApplicationContext(),gameActivity.class);
                gameAct.putStringArrayListExtra("names",names);

                for (int i=0;i<gameInstance.nbJoueur;i++){
                    Integer bou = gameInstance.getStopJoueurs().get(i).getBourse();
                    bourses.set(i,bou);
                }
                gameAct.putIntegerArrayListExtra("bourses",bourses);
                startActivity(gameAct);
                finish();
            }
        });
        custompopup.getNoBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainAct = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(MainAct);
                finish();
            }
        });
    }
}
