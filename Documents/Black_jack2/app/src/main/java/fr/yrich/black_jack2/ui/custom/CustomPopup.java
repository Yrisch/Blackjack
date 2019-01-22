package fr.yrich.black_jack2.ui.custom;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

import fr.yrich.black_jack2.R;

public class CustomPopup extends Dialog {

    private String title;
    private String subtitle;
    private Button YesBtn, NoBtn;
    private TextView titleView, subtitleView;

    //Constructeur
    public CustomPopup(Activity activity) {
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.pop_up);
        this.YesBtn = findViewById(R.id.yesBtn);
        this.NoBtn = findViewById(R.id.noBtn);
        this.titleView = findViewById(R.id.Tilte);
        this.subtitleView = findViewById(R.id.Subtitle);
    }

    public void settitle(String title) {
        titleView.setText(title);
    }

    public void setsubtitle(String subtitle) {
        subtitleView.setText(subtitle);
    }

    public Button getYesBtn() {
        return YesBtn;
    }

    public Button getNoBtn() {
        return NoBtn;
    }

    public void build() {
        show();
        titleView.setText(title);
        subtitleView.setText(subtitle);
    }

}
