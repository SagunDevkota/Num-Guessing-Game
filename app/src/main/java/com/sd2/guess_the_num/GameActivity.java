package com.sd2.guess_the_num;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    Button confirm;
    EditText input;
    TextView message,lastGuess,remaining;
    private int numLength,randomNumber,remainingChances=10;
    private String last;
    ArrayList<String> guessList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        confirm = findViewById(R.id.button);
        input = findViewById(R.id.randomInput);
        message = findViewById(R.id.message);
        lastGuess = findViewById(R.id.lastGuess);
        remaining = findViewById(R.id.remaining);

        Intent intent = getIntent();
        numLength = intent.getIntExtra("numLength",-1);
        if(numLength==2){
            randomNumber = (int)(Math.random() * (99 - 10 + 1) + 10);
        }else if(numLength==3){
            randomNumber = (int)(Math.random() * (999 - 100 + 1) + 99);
        }else if(numLength==4){
            randomNumber = (int)(Math.random() * (9999 - 1000 + 1) + 999);
        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length()>0) {
                    last = input.getText().toString();
                    guessList.add(last);
                    if (remainingChances > 0) {
                        if (Integer.parseInt(input.getText().toString()) > randomNumber) {
                            message.setText("Decrease Your Guess");
                            message.setTextColor(getResources().getColor(R.color.red));
                            remainingChances -= 1;
                            lastGuess.setText("Your Last Guess: " + last);
                            remaining.setText("Your Remaining Chances: " + remainingChances);
                        } else if (Integer.parseInt(input.getText().toString()) < randomNumber) {
                            message.setText("Increase Your Guess");
                            message.setTextColor(getResources().getColor(R.color.green));
                            remainingChances -= 1;
                            lastGuess.setText("Your Last Guess: " + last);
                            remaining.setText("Your Remaining Chances: " + remainingChances);
                        } else {
                            createDialog("Congratulation you made it at " + (10 - remainingChances) + " attempt" +
                                    " Your Guesses " + guessList +
                                    " Would you like to Play again?");
                        }
                    } else {
                        createDialog("Sorry Your chances are over.\n" +
                                "My Guess was " + randomNumber + "\n" +
                                "Your Guesses " + guessList +
                                " Would you like to play again?");
                    }
                    input.setText("");
                }
            }
        });
    }
    private void createDialog(String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameActivity.this);
        alertDialog.setTitle("Guess The Number")
                .setMessage(message)
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                        finish();
                        startActivity(intent1);
                    }
                }).show();
        alertDialog.create();
    }
}