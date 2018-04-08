package online.erupt.tictacgeektutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PlayerName extends AppCompatActivity {

    RadioButton playAs_X;
    RadioButton playAs_O;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        TextView geekListen = (TextView) findViewById(R.id.geek1);
        // ((Button) findViewById(R.id.singleplayer)).setClickable(false);
        playAs_X = (RadioButton) findViewById(R.id.play_as_X);
        playAs_O = (RadioButton) findViewById(R.id.play_as_O);
        geekListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((TextView) findViewById(R.id.letter_selection_textview)).setText("Choose Your Letter");
                ((TextView) findViewById(R.id.letter_selection_textview)).setEnabled(true);
                playAs_X.setEnabled(true);
                playAs_O.setEnabled(true);
            }
        });

    }

    public void submitName(View view) {
        EditText player1NameBox = (EditText) findViewById(R.id.player1);
        EditText player2NameBox = (EditText) findViewById(R.id.player2);
        EditText numberOfGames = (EditText) findViewById(R.id.numberOfG);
        String player1NameText = player1NameBox.getText().toString();
        String player2NameText = player2NameBox.getText().toString();
        String number = numberOfGames.getText().toString();

        if (number.length() > 3) {
            number = "999";
            numberOfGames.setText(R.string.default_max_games);
        }
        if (number.equals("") || Integer.parseInt(number) <= 0) {
            numberOfGames.setText(R.string.default_min_games);
            number = "1";
        }

//        if(player1NameText.equals("")||player2NameText.equals("")){
//            toastMessage("Please enter names of both the players");
//            return;
//        }
        if (player1NameText.equals("")) {
            player1NameText = "Player 1";
            player1NameBox.setText(R.string.player_1_default_name);
        }
        if (player2NameText.equals("")) {
            player2NameText = "Player 2";
            player2NameBox.setText(R.string.player_2_default_name);
        }
        if (playAs_O.isChecked()) {
            Intent intent = new Intent(this, PlayGame2.class);
            intent.putExtra("Player 1", player1NameText);
            intent.putExtra("Player 2", player2NameText);
            intent.putExtra("Number", number);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                finish();
            }
        if (playAs_X.isChecked()) {
                intent = new Intent(this, PlayGame.class);
                intent.putExtra("Player 1", player1NameText);
                intent.putExtra("Player 2", player2NameText);
                intent.putExtra("Number", number);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    finish();
                }
            }

        }
//    private void toastMessage(String string)
//    {
//        Context context = getApplicationContext();
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, string,duration);
//        toast.show();
//    }
    }
}
