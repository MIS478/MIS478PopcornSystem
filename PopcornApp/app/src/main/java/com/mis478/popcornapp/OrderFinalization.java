package com.mis478.popcornapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class OrderFinalization extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finalization);
        Intent intent = getIntent();
        Bundle info = intent.getExtras();

        //Fills in the first name of customer
        String fNamemessage = info.getString("FNAME");
        TextView fName = (TextView) findViewById(R.id.FinalizationFnameBox);
        fName.setText(fNamemessage);

        //Fills in the last name of customer
        String lNamemessage = info.getString("LNAME");
        TextView lName = (TextView) findViewById(R.id.FinalizationLnameBox);
        lName.setText(lNamemessage);

        //Fills in the address of customer
        String streetnumbermessage = info.getString("STREETNUMBER");
        String streetnamemessage = info.getString("STREETNAME");
        TextView address = (TextView) findViewById(R.id.FinalizationAddress);
        address.setText(streetnumbermessage + " " + streetnamemessage);

        //Fills in the city of customer
        String citymessage = info.getString("CITY");
        TextView city = (TextView) findViewById(R.id.FinalizationCity);
        city.setText(citymessage);

        //Fills in the state of customer
        String statemessage = info.getString("STATE");
        TextView state = (TextView) findViewById(R.id.FinalizationState);
        state.setText(statemessage);

        //Fills in the zip of customer
        String zipmessage = info.getString("ZIP");
        TextView zip = (TextView) findViewById(R.id.FinalizationZip);
        zip.setText(zipmessage);

        //Fills in the phone number of customer if it is available
        String phonemessage = info.getString("PHONE");

        TextView phone = (TextView) findViewById(R.id.FinalizationPhone);
        if (phonemessage.isEmpty()) {
            phone.setText("Not given");
        } else {
            phone.setText(phonemessage);
        }

        //Fills in the email of customer
        String emailmessage = info.getString("EMAIL");
        TextView email = (TextView) findViewById(R.id.FinalizationEmail);
        if (emailmessage.isEmpty()) {
            email.setText("Not given");
        } else {
            email.setText(emailmessage);
        }
        //Fills in the number of Buffalo Cheddar Cheese
        int BuffChedMessage = Integer.parseInt(info.getString("BUFFCHEDAMT"));
        TextView BuffChed = (TextView) findViewById(R.id.FinalizationBuffChed);
        if(BuffChedMessage == 0)
        {
        BuffChed.setVisibility(View.GONE);
        } else if (BuffChedMessage == 1){
            BuffChed.setText("Buffalo Cheddar Cheese");
        } else {
            BuffChed.setText("Buffalo Cheddar Cheese x" + BuffChedMessage);
        }

        //Fills in the number of Premium Caramel Corn
        int CarmCornMessage = Integer.parseInt(info.getString("CARMCORNAMT"));
        TextView CarmCorn = (TextView) findViewById(R.id.FinalizationCarmCorn);
        if(CarmCornMessage == 0)
        {
            CarmCorn.setVisibility(View.GONE);
        } else if (CarmCornMessage == 1){
            CarmCorn.setText("Premium Caramel Corn");
        } else {
            CarmCorn.setText("Premium Caramel Corn x" + CarmCornMessage);
        }

        //Fills in the number of Cheese Lover's Collection
        int CheeseLoveMessage = Integer.parseInt(info.getString("CHEESELOVEAMT"));
        TextView CheeseLove = (TextView) findViewById(R.id.FinalizationCheeseLove);
        if(CheeseLoveMessage == 0)
        {
            CheeseLove.setVisibility(View.GONE);
        } else if (CheeseLoveMessage == 1){
            CheeseLove.setText("Cheese Lover's Collection");
        } else {
            CheeseLove.setText("Cheese Lover's Collection x" + CheeseLoveMessage);
        }

        //Fills in the number of White Chocolatey Pretzels
        int WhitePretzelMessage = Integer.parseInt(info.getString("WHITEPRETZELAMT"));
        TextView WhitePretzel = (TextView) findViewById(R.id.FinalizationWhitePretzel);
        if(WhitePretzelMessage == 0)
        {
            WhitePretzel.setVisibility(View.GONE);
        } else if (WhitePretzelMessage == 1){
            WhitePretzel.setText("White Chocolatey Pretzels");
        } else {
            WhitePretzel.setText("White Chocolatey Pretzels x" + WhitePretzelMessage);
        }

        //Fills in the number of Gold Level Military
        int GoldMilitaryMessage = Integer.parseInt(info.getString("GOLDMILITARYAMT"));
        TextView GoldMilitary = (TextView) findViewById(R.id.FinalizationGoldMilitary);
        if(GoldMilitaryMessage == 0)
        {
            GoldMilitary.setVisibility(View.GONE);
        } else if (GoldMilitaryMessage == 1){
            GoldMilitary.setText("Gold Level Military");
        } else {
            GoldMilitary.setText("Gold Level Military x" + GoldMilitaryMessage);
        }

        //Fills in the number of Silver Level Military
        int SilverMilitaryMessage = Integer.parseInt(info.getString("SILVERMILITARYAMT"));
        TextView SilverMilitary = (TextView) findViewById(R.id.FinalizationSilverMilitary);
        if(SilverMilitaryMessage == 0)
        {
            SilverMilitary.setVisibility(View.GONE);
        } else if (SilverMilitaryMessage == 1){
            SilverMilitary.setText("Silver Level Military");
        } else {
            SilverMilitary.setText("Silver Level Military x" + SilverMilitaryMessage);
        }

        //fills in the donation amount if any
        int donationmessage = Integer.parseInt(info.getString("DONATIONAMT"));
        TextView donation = (TextView) findViewById(R.id.FinalizationDonationAmt);
        if (donationmessage == 0)
        {
            donation.setVisibility(View.GONE);
        } else {
            donation.setText("Donation of $" + donationmessage);
        }

        //find out total
        int BuffChedPrice = Integer.parseInt(info.getString("BUFFCHEDPRICE"));
        int CarmCornPrice = Integer.parseInt(info.getString("CARMCORNPRICE"));
        int CheeseLovePrice = Integer.parseInt(info.getString("CHEESELOVEPRICE"));
        int WhitePretzelPrice = Integer.parseInt(info.getString("WHITEPRETZELPRICE"));
        int GoldMilitaryPrice = Integer.parseInt(info.getString("GOLDMILITARYPRICE"));
        int SilverMilitaryPrice = Integer.parseInt(info.getString("SILVERMILITARYPRICE"));

        int totalamt = BuffChedMessage * BuffChedPrice + CarmCornMessage * CarmCornPrice + CheeseLoveMessage * CheeseLovePrice + WhitePretzelMessage * WhitePretzelPrice + GoldMilitaryMessage * GoldMilitaryPrice + SilverMilitaryMessage * SilverMilitaryPrice + donationmessage;
        TextView total = (TextView) findViewById(R.id.FinalizationTotal);
        total.setText("Total: $" + totalamt);
    }

    public void ToCustInfo(View view) {
        //return to the Customer Information Input screen
        dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
        dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
    }

    public void SubmitOrder(View view) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_status_page, menu);
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

        if (id == R.id.sales_mode) {
            Intent intent = new Intent(this, SellProducts.class);
            startActivity(intent);
        }
        if (id == R.id.donation) {
            Intent intent = new Intent(this, Donation.class);
            startActivity(intent);
        }
        if (id == R.id.ScoutMain) {
            Intent intent = new Intent(this, ScoutMainPage.class);
            startActivity(intent);
        }
        if (id == R.id.log) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
