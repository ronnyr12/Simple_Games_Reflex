package com.example.simple_games_reflex;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    //phase 2 - declaration (say to the program what elements we have created in design)
    Button btn_start, btn_reflex;

    //phase 5.1
    long startTime;
    //phase 6
    long endTime;
    //phase 7
    long currentTime;
    //phase 9.3
    long bestTime = 10000; //bad default value so the 1st attempt will replace
    //phase 9.1
    TextView tv_best;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //phase 3 - referencing (connecting the button here to the buttons in the xml file)
        btn_start = findViewById(R.id.btn_start);
        btn_reflex = findViewById(R.id.btn_reflex);

        //phase 9.2
        tv_best = findViewById(R.id.tv_best);
        //phase 5.3 - staring mode of game
        btn_start.setEnabled(true);
        btn_reflex.setEnabled(false);

        //phase 9.4
        tv_best.setText("Best Time: "+bestTime+ " ms");
        //phase 4 - clicking events
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // phase 5 - get code #1 from : https://pastebin.com/BgQrdGsK
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //phase 8
                        btn_start.setEnabled(false);
                        btn_reflex.setText("");
                        //phase 5.2
                        startTime = System.currentTimeMillis(); //0.001 of a second
                        //phase 5.3 - get code #2 from : https://pastebin.com/HXPqfkSk
                        btn_reflex.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(),
                                        R.color.purple_700));
                        //phase 5.4 - buttons mode during the game
                        /*btn_start.setEnabled(false);*/    //phase 8 - move line of code
                        btn_reflex.setText("PRESS");
                        btn_reflex.setEnabled(true);
                    }
                }, 2000);
            }
        });

        btn_reflex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //phase 6.1 - get code #3 from : https://pastebin.com/mizaqdp4
                endTime = System.currentTimeMillis();
                //phse 7 -
                currentTime = endTime - startTime;
                //end of phase 7 adding code
                btn_reflex.setBackgroundColor(
                        ContextCompat.getColor(getApplicationContext(),
                                R.color.purple_200));
                btn_start.setEnabled(true);
                /*btn_reflex.setText("PRESS");*/    //phase 7.1 - change text to next line of code
                btn_reflex.setText(currentTime+" ms");
                btn_reflex.setEnabled(false);

                //phase 10 - get code #4 from :
                if(currentTime < bestTime) {
                    bestTime = currentTime;
                    tv_best.setText("Best Time: " + bestTime + " ms");
                }
            }
        });



    }
}