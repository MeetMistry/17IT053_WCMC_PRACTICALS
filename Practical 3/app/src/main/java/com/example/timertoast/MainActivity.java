package com.example.timertoast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Chronometer timer;
    int i = -1;
    int duration = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer =(Chronometer)findViewById(R.id.chronometer);
        timer.start();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    i++;
                    if(i >= duration){
                        Toast.makeText(MainActivity.this,"Toast " + (i/5),Toast.LENGTH_LONG).show();
                        duration = duration + 5;
                    }
                }
            });
        }
    }
}
