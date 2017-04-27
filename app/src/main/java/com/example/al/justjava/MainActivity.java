package com.example.al.justjava;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name);
        String name = nameField.getText().toString();
        int p = 5 ;
        CheckBox hasMilk = (CheckBox)findViewById(R.id.Milk);
        boolean Milk = hasMilk.isChecked();
        CheckBox hasSugar = (CheckBox)findViewById(R.id.Sugar);
        boolean Sugar = hasSugar.isChecked();
        if(Milk){
            p = p + 2;
        }
        if(Sugar){
            p = p + 1;
        }
        String priceMessage = "Name: " + name + "\nAdd Milk:" + Milk  + "\nAdd Sugar:" + Sugar + "\nTotle:  $ "+ num*p + "\nThank you!";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, name);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for" + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
       // intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//       //
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for" + name);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        displayMessage(priceMessage);
    }

    public void increment(View view) {
        num = num + 1;
        display(num);

    }

    public void decrement(View view) {
        num = num - 1;
        if(num<0) num=0;
        display(num);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
