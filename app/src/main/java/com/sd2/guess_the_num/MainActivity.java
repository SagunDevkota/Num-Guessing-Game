package com.sd2.guess_the_num;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup options;
    RadioButton radioButton2,radioButton3,radioButton4;
    Button submit;
    private int numLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        options = findViewById(R.id.radioGroup);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            if(radioButton2.isChecked()){
                numLength = 2;
            }else if(radioButton3.isChecked()){
                numLength = 3;
            }else if(radioButton4.isChecked()){
                numLength = 4;
            }
            Intent intent = new Intent(getApplicationContext(),GameActivity.class);
            finish();
            intent.putExtra("numLength",numLength);
            startActivity(intent);
        });
    }
}