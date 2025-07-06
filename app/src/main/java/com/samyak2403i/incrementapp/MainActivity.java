/**
 * MIT License
 *
 * Copyright (c) 2024 Samyak Kamble
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.samyak2403i.incrementapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

// Import Start.io SDK
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.StartAppAd.AdMode;
import com.startapp.sdk.adsbase.AutoInterstitialPreferences;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;

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
    
    // Declare StartAppAd for interstitial ads
    private StartAppAd startAppAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize the Start.io SDK with your App ID
        StartAppSDK.init(this, "206321451", false);
        
        // For GDPR compliance - optional
        StartAppSDK.setUserConsent(this, 
                "pas",
                System.currentTimeMillis(), 
                true);
        
        // Enable return ads - using the correct method
        StartAppAd.showAd(this);
        
        setContentView(R.layout.activity_main);  // Set the layout file for this activity

        // Initialize the StartAppAd object for interstitial ads
        startAppAd = new StartAppAd(this);

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
                
                // Show interstitial ad every 5th click
                if (number % 5 == 0) {
                    showInterstitial();
                }
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
        
        // Add banner ad at the bottom of the screen
        setupBannerAd();
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
    
    /**
     * Method to set up a banner ad at the bottom of the screen
     */
    private void setupBannerAd() {
        // Create a banner ad
        Banner banner = new Banner(this);
        
        // Add the banner to the layout
        RelativeLayout bannerLayout = findViewById(R.id.bannerAdContainer);
        if (bannerLayout != null) {
            bannerLayout.addView(banner);
        }
        
        // Set banner listener for lifecycle events
        banner.setBannerListener(new BannerListener() {
            @Override
            public void onReceiveAd(View view) {
                // Banner has been received
            }

            @Override
            public void onFailedToReceiveAd(View view) {
                // Banner failed to load
            }

            @Override
            public void onImpression(View view) {
                // Banner impression
            }

            @Override
            public void onClick(View view) {
                // Banner clicked
            }
        });
    }
    
    /**
     * Method to show interstitial ad
     */
    private void showInterstitial() {
        startAppAd.loadAd(AdMode.FULLPAGE, new AdEventListener() {
            @Override
            public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                // Ad loaded successfully, show it
                startAppAd.showAd(new AdDisplayListener() {
                    @Override
                    public void adHidden(com.startapp.sdk.adsbase.Ad ad) {
                        // Ad hidden
                    }

                    @Override
                    public void adDisplayed(com.startapp.sdk.adsbase.Ad ad) {
                        // Ad displayed
                    }

                    @Override
                    public void adClicked(com.startapp.sdk.adsbase.Ad ad) {
                        // Ad clicked
                    }

                    @Override
                    public void adNotDisplayed(com.startapp.sdk.adsbase.Ad ad) {
                        // Ad not displayed
                    }
                });
            }

            @Override
            public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                // Failed to load ad
            }
        });
    }
    
    @Override
    public void onBackPressed() {
        // Show an ad when the back button is pressed
        startAppAd.onBackPressed();
        super.onBackPressed();
    }
}
