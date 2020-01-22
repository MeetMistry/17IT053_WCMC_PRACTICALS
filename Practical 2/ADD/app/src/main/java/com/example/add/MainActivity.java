package com.example.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText)findViewById(R.id.editText1);
        number2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.add_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int sum = num1 + num2;

                Toast.makeText(getApplicationContext(),"Sum of Two number is " + sum,Toast.LENGTH_LONG).show();

            }
        });


    }
}
