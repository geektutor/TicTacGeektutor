package online.erupt.tictacgeektutor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SeriesResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_series_result);
        Intent intent = getIntent();
        String player1Wins = String.valueOf(intent.getExtras().getInt("Player 1 Wins"));
        String player2Wins = String.valueOf(intent.getExtras().getInt("Player 2 Wins"));
        String draws = String.valueOf(intent.getExtras().getInt("Draws"));
        String player1Name = intent.getExtras().getString("Player 1 Name");
        String player2Name = intent.getExtras().getString("Player 2 Name");
        TextView player1NameView = (TextView) findViewById(R.id.p1name);
        TextView player2NameView = (TextView) findViewById(R.id.p2name);
        TextView player1WinsView = (TextView) findViewById(R.id.p1wins);
        TextView player2WinsView = (TextView) findViewById(R.id.p2wins);
        TextView drawsView = (TextView) findViewById(R.id.draws);


        if(Integer.parseInt(player1Wins)>Integer.parseInt(player2Wins)){
            player1NameView.setTextColor(Color.GREEN);
            player2NameView.setTextColor(Color.RED);
        }
        else if(Integer.parseInt(player1Wins)<Integer.parseInt(player2Wins)){
            player2NameView.setTextColor(Color.GREEN);
            player1NameView.setTextColor(Color.RED);
        }
        else
        {
            player2NameView.setTextColor(Color.YELLOW);
            player1NameView.setTextColor(Color.YELLOW);
        }
        player1NameView.setText(player1Name);
        player2NameView.setText(player2Name);
        player1WinsView.setText(player1Wins);
        player2WinsView.setText(player2Wins);
        drawsView.setText(draws);

    }

    public void onClickContinue(View view){
        Intent intent = new Intent(this,MainActivity.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            finish();
        }
    }
}
