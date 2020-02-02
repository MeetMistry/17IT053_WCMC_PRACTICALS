package com.example.practical5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    RelativeLayout p1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        p1 = findViewById(R.id.p1);
        t1 = findViewById(R.id.t1);

        Intent intent = getIntent();
        String temp = intent.getStringExtra("flag");

        t1.setText(temp);
        if (temp.equals("Success")) {
            p1.setBackgroundColor(Color.parseColor("#00ff00"));
            t1.setText("17IT053 has successfully logged in ...");
            //i.removeExtra("Status");
        }
        else{
            p1.setBackgroundColor(Color.parseColor("#ff0000"));
            t1.setText("Id or Password incorrect ...");
        }
    }
}
