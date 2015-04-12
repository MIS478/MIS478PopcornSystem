package com.mis478.popcornapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Login extends ActionBarActivity {
   // public final static String EXTRA_MESSAGE = "com.mis478.popcornapp.MESSAGE";
    Integer x = 1;
    Integer y = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void Login(View view) {

        EditText LoginEditText = (EditText) findViewById(R.id.LoginUsername);
        EditText PasswordEditText = (EditText) findViewById(R.id.LoginPassword);
        String LoginText = LoginEditText.getText().toString();
        String PasswordText = PasswordEditText.getText().toString();
        if (LoginText.equals("test") && PasswordText.equals("123") ) {
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.scoutGoal) {
            Intent intent = new Intent(this, ScoutGoal.class);
            startActivity(intent);
        }
        if (id == R.id.deliveryMode) {
            Intent intent = new Intent(this, DeliveryMode.class);
            startActivity(intent);
        }
        if (id == R.id.pastSales) {
            Intent intent = new Intent(this, PastSales.class);
            startActivity(intent);
        }
        if (id == R.id.denLeaderMain) {
            Intent intent = new Intent(this, DenLeaderMain.class);
            startActivity(intent);
        }
        if (id == R.id.den_sales_tracking) {
            Intent intent = new Intent(this, DenSalesTracking.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
