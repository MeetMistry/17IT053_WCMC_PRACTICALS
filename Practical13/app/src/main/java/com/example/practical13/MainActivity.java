package com.example.practical13;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonPip;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        buttonPip = findViewById(R.id.buttonPIP);

        buttonPip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Display d = getWindowManager().getDefaultDisplay();
                    Point p = new Point();
                    d.getSize(p);
                    int width = p.x;
                    int height = p.y;

                    Rational ratio = new Rational(width, height);
                    PictureInPictureParams.Builder pip_Builder = new PictureInPictureParams.Builder();
                    pip_Builder.setAspectRatio(ratio).build();
                        enterPictureInPictureMode(pip_Builder.build());
                }
            }
        });
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig){
        if(isInPictureInPictureMode){
            actionBar.hide();
        } else {
            actionBar.show();
        }
    }
}
