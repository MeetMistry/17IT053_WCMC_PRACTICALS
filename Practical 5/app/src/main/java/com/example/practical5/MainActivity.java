package com.example.practical5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText idet , passet;
    Button btn,btn2;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idet = findViewById(R.id.idet);
        passet = findViewById(R.id.passet);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idet.getText().toString().trim();
                String pass = passet.getText().toString();

                if (count == 2){

                    btn.setEnabled(false);
                }
                if (id.isEmpty() || pass.isEmpty() ){

                    count++;
                }
                else if (id.equals("abc@gmail.com")&& pass.equals("1234")){

                    goToNextPage("Success");
                }
                else if (id != "1234" || pass != "1234"){
                    //finish();
                    goToNextPage("Not");
                }
            }
        });

    }
    void goToNextPage(String i){

        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("flag",i);
        startActivity(intent);
    }
}