package com.example.froyd.beasy;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;

public class Signup extends AppCompatActivity {

    EditText edit_name;
    EditText edit_username;
    EditText edit_pass;
    Button btn_sign;


    private  static final String REGISTER_URL="http://ebeasy.com.br/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username=(EditText)findViewById(R.id.id_username);
        edit_name=(EditText)findViewById(R.id.id_name);
        edit_pass=(EditText)findViewById(R.id.id_pass);
        btn_sign=(Button)findViewById(R.id.btn_signup);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser(){
        String name=edit_name.getText().toString().trim().toLowerCase();
        String login=edit_username.getText().toString().trim().toLowerCase();
        String pass=edit_pass.getText().toString().trim().toLowerCase();
        register(username, login, pass);
    }
    private void register(String username, String pass){
        String urlsulfix="?username="+username+"&password="+pass+"&name="+name;
        class RegisterUser extends AsyncTask<String,Void,String>{
            ProgressDialog loading;

            @Override
            protected void  onPreExecute(){
                super.onPreExecute();
                loading=ProgressDialog.show(Signup.this,"Please wait",null,true,true );

            }
            @Override
            protected void onPostExecute(String s){
                super.onPreExecute(s);
                Toast.makeText(getApplicationContext(),"Internet Not Found", Toast.LENGTH_SHORT.show());
            }
            @Override
            protected String doInBackGround(String... params) {
                String s = params[0];
                BufferedReader bufferedReader=null;
                try {
                    URL url=new URL(REGISTER_URL);

                }catch (Exception e){
                    return null;
                }
            }
        }
    }
}

