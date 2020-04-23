package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practical10.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView signupTextView;
    private EditText editTextEmail, editTextPassword;
    private Button loginButton;
    String finalResult;
    String PasswordHolder, EmailHolder;
    String HttpURL = "https://crimereporterandmmissingpersonreporter.000webhostapp.com/login.php";
    Boolean CheckEditText;
    ProgressDialog progressDialog;
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String Email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.loginEmailEditText);
        editTextPassword = (EditText)findViewById(R.id.loginPasswordEditText);
        loginButton = (Button)findViewById(R.id.loginButton);
        signupTextView = (TextView)findViewById(R.id.newAccountTextView);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){
                    UserLoginFunction(EmailHolder, PasswordHolder);
                }else {
                    Toast.makeText(MainActivity.this, "Please Fill all the Fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot(){

        EmailHolder = editTextEmail.getText().toString();
        PasswordHolder = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){
            CheckEditText = false;
        }else {
            CheckEditText = true;
        }
    }

    public void UserLoginFunction(final String email, final String password){

        class UserLoginClass extends AsyncTask<String, Void, String>{

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                progressDialog = ProgressDialog.show(MainActivity.this, "Loading Data",
                        null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg){
                super.onPostExecute(httpResponseMsg);
                progressDialog.dismiss();

                if (httpResponseMsg.equalsIgnoreCase("Data Matched")){
                    finish();
                    Intent intent = new Intent(MainActivity.this, Report.class);
                    intent.putExtra(Email, email);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("email", params[0]);
                hashMap.put("password", params[1]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();
        userLoginClass.execute(email, password);
    }

}
