package com.makestuffup.richtanner.d20critroller;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDice;
    private TextView textViewCritical;
    private Random rng = new Random();
    private MediaPlayer mpRoll;
    private MediaPlayer mpFail;
    private MediaPlayer mpWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCritical = findViewById(R.id.text_view_crit);
        textViewCritical.setText(R.string.start_string);

        imageViewDice = findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int randomNumber = rng.nextInt(20) + 1;

        // reset the TextView each roll
        textViewCritical.setText("");

        mpRoll = MediaPlayer.create(MainActivity.this, R.raw.rolldice);
        mpRoll.start();

        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.d1);
                // make a sound!
                mpFail = MediaPlayer.create(MainActivity.this, R.raw.failwah);
                mpFail.start();
                // show a label!
                textViewCritical.setText(R.string.lose_string);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.d2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.d3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.d4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.d5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.d6);
                break;
            case 7:
                imageViewDice.setImageResource(R.drawable.d7);
                break;
            case 8:
                imageViewDice.setImageResource(R.drawable.d8);
                break;
            case 9:
                imageViewDice.setImageResource(R.drawable.d9);
                break;
            case 10:
                imageViewDice.setImageResource(R.drawable.d10);
                break;
            case 11:
                imageViewDice.setImageResource(R.drawable.d11);
                break;
            case 12:
                imageViewDice.setImageResource(R.drawable.d12);
                break;
            case 13:
                imageViewDice.setImageResource(R.drawable.d13);
                break;
            case 14:
                imageViewDice.setImageResource(R.drawable.d14);
                break;
            case 15:
                imageViewDice.setImageResource(R.drawable.d15);
                break;
            case 16:
                imageViewDice.setImageResource(R.drawable.d16);
                break;
            case 17:
                imageViewDice.setImageResource(R.drawable.d17);
                break;
            case 18:
                imageViewDice.setImageResource(R.drawable.d18);
                break;
            case 19:
                imageViewDice.setImageResource(R.drawable.d19);
                break;
            case 20:
                imageViewDice.setImageResource(R.drawable.d20);
                // make a sound!
                playWin();
                // show a label!
                textViewCritical.setText(R.string.win_string);
                break;

        }
    }

    private void playWin() {
        int randomNumber = rng.nextInt(3) + 1;

        switch (randomNumber) {
            case 1:
                mpWin = MediaPlayer.create(MainActivity.this, R.raw.torpedo);
                mpWin.start();
                break;
            case 2:
                mpWin = MediaPlayer.create(MainActivity.this, R.raw.victory);
                mpWin.start();
                break;
            case 3:
                mpWin = MediaPlayer.create(MainActivity.this, R.raw.zfanfare);
                mpWin.start();
                break;
        }


    }
}
