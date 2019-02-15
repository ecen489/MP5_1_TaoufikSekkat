package com.example.tsekk.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp1, mp2, mp3;
    TextView tv;
    ImageView iv;
    boolean ismp1 = false;
    boolean ismp2 = false;
    boolean ismp3 = false;
    int lastplayed = 0;
    //Drawable d1 = getResources().getDrawable(R.drawable.beatles);
    //Drawable d2 = getResources().getDrawable(R.drawable.eminem);
    //Drawable d3 = getResources().getDrawable(R.drawable.khalid);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp1 = MediaPlayer.create(this,R.raw.beatles);
        mp2 = MediaPlayer.create(this, R.raw.eminem);
        mp3 = MediaPlayer.create(this, R.raw.khalid);

        final Button button_sub = findViewById(R.id.play);
        button_sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (lastplayed){
                    case 0:
                        //do nothing
                        break;
                    case 1:
                        if(!ismp1){mp1.start(); ismp1=true;}
                        break;
                    case 2:
                        if(!ismp2){mp2.start(); ismp2=true;}
                        break;
                    case 3:
                        if(!ismp3){mp3.start(); ismp3=true;}
                        break;
                }
            }
        });

        final Button button_plus = findViewById(R.id.stop);
        button_plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ismp1){mp1.pause(); ismp1=false;}
                if(ismp2){mp2.pause(); ismp2=false;}
                if(ismp3){mp3.pause(); ismp3=false;}
            }
        });


        tv = (TextView) findViewById(R.id.textView);
        //iv = (ImageView) findViewById(R.id.imageView);

    }

    public void onRadioButtonClicked(View view){

        boolean check = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButton_beatles:
                if(check) {
                    tv.setText("Now Playing: Let it be by the Beatles");
                    //Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();

                    //iv.setImageDrawable(d1);
                    if(ismp2){mp2.pause(); ismp2=false; }
                    if(ismp3){mp3.pause(); ismp3=false; }
                    mp1.start();
                    ismp1 = true;
                }
                ImageView mImageView;
                mImageView = (ImageView) findViewById(R.id.imageViewId);
                mImageView.setImageResource(R.drawable.beatles);
                lastplayed = 1;
                break;

            case R.id.radioButton_eminem:
                if(check) {
                    tv.setText("Now Playing: Lose Yourself by Eminem");
                    //iv.setImageDrawable(d2);
                    if(ismp1){mp1.pause(); ismp1=false; }
                    if(ismp3){mp3.pause(); ismp3=false; }
                    mp2.start();
                    ismp2 = true;
                }
                ImageView mImageView1;
                mImageView1 = (ImageView) findViewById(R.id.imageViewId);
                mImageView1.setImageResource(R.drawable.eminem);
                lastplayed = 2;
                break;

            case R.id.radioButton_khalid:
                if(check) {
                    tv.setText("Now Playing: Location by Khalid");
                    //iv.setImageDrawable(d3);
                    if(ismp1){mp1.pause(); ismp1=false; }
                    if(ismp2){mp2.pause(); ismp2=false; }
                    mp3.start();
                    ismp3 = true;
                }
                ImageView mImageView2;
                mImageView2 = (ImageView) findViewById(R.id.imageViewId);
                mImageView2.setImageResource(R.drawable.khalid);
                lastplayed = 3;
                break;
        }
    }
}

