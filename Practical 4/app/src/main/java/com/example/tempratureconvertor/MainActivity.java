package com.example.tempratureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    double f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter the Temprature value", Toast.LENGTH_SHORT).show();
                }else {
                    f = Double.parseDouble(String.valueOf(editText.getText()));
                    double b = f - 32;
                    double c = b * 5/9;
                    String r = String.valueOf(c);
                    Toast.makeText(MainActivity.this, r + " 'C", Toast.LENGTH_SHORT).show();
                }
                editText.getText().clear();
            }
        });

    }
}
