package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import javax.sql.*;
import java.*;
import java.util.ArrayList;

import javax.*;

public class Login extends ActionBarActivity {

    Integer x = 1;
    Integer y = 1;
    public static final String KEY_121 = "http://207.179.202.218:1515/joe/1.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }
    public void ConnectToDatabase(View View){
        InputStream is = null;

        EditText LoginEditText = (EditText) findViewById(R.id.LoginUsername);
        EditText PasswordEditText = (EditText) findViewById(R.id.LoginPassword);
        String LoginText = LoginEditText.getText().toString();
        String PasswordText = PasswordEditText.getText().toString();
        String result = "";
        //the year data to send
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("year","420"));


        //http post
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();


        }catch(Exception e){
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        //convert response to string
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                line.toString();
                String[] splitArray = line.split("\\}");

                for (int i = 0; i < splitArray.length; i++) {

                    if (splitArray[i].contains(LoginText) && splitArray[i].contains(PasswordText)
                            && !LoginText.equals("") && !PasswordText.equals(""))
                    {
                        if (LoginText.equals("John") && PasswordText.equals("111"))
                        {

                            Intent intent = new Intent(this, DenLeaderMain.class);
                            startActivity(intent);
                            break;
                        } else {

                            Intent intent = new Intent(this, ScoutStatusPage.class);
                            startActivity(intent);
                            break;
                                }
                    } else if( i == (splitArray.length -1))
                       {
                           new AlertDialog.Builder(this)
                                   .setTitle("Incorrect login")
                                   .setMessage("You entered the wrong password or username")
                                   .setIcon(android.R.drawable.ic_dialog_alert)
                                   .show();
                       }
                    }


                }

            is.close();
            result=sb.toString();

        }catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
        }
        //parse json data


}
    public void Login(View view) {

        EditText LoginEditText = (EditText) findViewById(R.id.LoginUsername);
        EditText PasswordEditText = (EditText) findViewById(R.id.LoginPassword);
        String LoginText = LoginEditText.getText().toString();
        String PasswordText = PasswordEditText.getText().toString();
        if (LoginText.equals("scout") && PasswordText.equals("123") ) {
            Intent intent = new Intent(this, ScoutStatusPage.class);
            startActivity(intent);
        }
        else if (LoginText.equals("leader") && PasswordText.equals("123"))
        {
            Intent intent = new Intent(this, DenLeaderMain.class);
            startActivity(intent);
        }
        else { new AlertDialog.Builder(this)
                .setTitle("Incorrect login")
                .setMessage("You entered the wrong password or username")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        }
    }
//    public void clrUN(View view) {
//        EditText username = (EditText) findViewById(R.id.editText);
//        //so it doesn't reset if they hit it again
//        if (x == 1) {
//            username.setText("");
//            x++;
//        }
//
//    }
//    public void clrPASS(View view) {
//        EditText pass = (EditText) findViewById(R.id.editText2);
//        //so it doesn't reset if they hit it again
//        if (y == 1) {
//            pass.setText("");
//            y++;
//        }
//    }
}
