package com.egeperk.kennygamejava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationAttributes;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int number;
    Button button;
    ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12};
        button = findViewById(R.id.button);
        number = 0;
        hideImages();

    }

    public void add(View view) {
        number++;
        textView2.setText(""+ number);

    }

    public void start(View view) {



        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                textView.setText(millisUntilFinished/1000 + "");
            }

            @Override
            public void onFinish() {

                textView.setText("It's Over!");
                handler.removeCallbacks(runnable);
                for (ImageView image: imageArray) {
                    image.setVisibility(View.INVISIBLE);


                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    i.putExtra("score", number);
                    startActivity(i);

                }
            }
        }.start();

        button.setEnabled(false);
    }

    //// Görünmez yaptık

    public void hideImages() {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image: imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }

                /// Random sayı alacak 0 - 11 arasında
                Random random = new Random();
                int i = random.nextInt(12);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable, 500);
            }
        };

        handler.post(runnable);

    }
}