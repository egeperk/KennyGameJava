package com.egeperk.kennygamejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = findViewById(R.id.textView2);
        int number = getIntent().getIntExtra("score", 0);
        textView2.setText(""+number);


    }

    public void restart(View view) {

        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }


}