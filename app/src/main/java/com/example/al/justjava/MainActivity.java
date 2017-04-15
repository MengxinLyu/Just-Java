package com.example.al.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int m = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {


        String priceMessage="Totle:  $ "+ m*5 + "\nThank you!";
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        m = m + 1;
        display(m);
        displayPrice(m*5);
       // String priceMessage="Totle: $ "+ m*5+ "\nThank you!";
       // displayMessage(priceMessage);

    }

    public void decrement(View view) {
        m = m - 1;
        if(m<0) m=0;
        display(m);
        displayPrice(m*5);
        //String priceMessage="Totle:$"+ m*5+ "\nThank you!";
       // displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Totle:  $ " + number + "\nPlease Pay Up!" );
       // priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
