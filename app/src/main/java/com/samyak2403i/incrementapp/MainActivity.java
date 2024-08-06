package com.samyak2403i.incrementapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * MainActivity class that manages the UI and handles user interactions.
 */
public class MainActivity extends AppCompatActivity {

    // Declare a TextView variable to display the number
    private TextView numberTextView;

    // Declare Button variables to trigger the increment and decrement actions
    private Button incrementButton;
    private Button decrementButton;

    // Declare an integer variable to keep track of the number
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Set the layout file for this activity

        // Initialize the TextView and Buttons by finding their IDs in the layout
        numberTextView = findViewById(R.id.numberTextView);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);

        // Set an OnClickListener on the increment button to handle click events
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to increment the number
                incrementNumber();
            }
        });

        // Set an OnClickListener on the decrement button to handle click events
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to decrement the number
                decrementNumber();
            }
        });
    }

    /**
     * Method to increment the number.
     */
    private void incrementNumber() {
        number++;
        // Update the TextView with the new number
        numberTextView.setText(String.valueOf(number));
    }

    /**
     * Method to decrement the number.
     * The number will not go below 0.
     */
    private void decrementNumber() {
        if (number > 0) {
            number--;
        }
        // Update the TextView with the new number
        numberTextView.setText(String.valueOf(number));
    }
}
