package com.example.practical7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                break;
            case R.id.item2:
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#7FFF00"));
                break;
            case R.id.item3:
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0000FF"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
