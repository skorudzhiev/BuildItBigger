package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.displaylibrary.activity.DisplayActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity {

    Context context;
    private static final String ID = "ca-app-pub-3940256099942544/1033173712";
    private static final String JOKE_EXTRA_KEY = "joke";

    boolean isPaidVersion;
    ProgressBar progressBar;
    private  InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
        isPaidVersion = getResources().getBoolean(R.bool.is_paid_version);

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        if (!isPaidVersion) {
            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId(ID);
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Toast.makeText(context, "onAdFailedToLoad - " + errorCode, Toast.LENGTH_LONG).show();
                }
            });
            requestNewInterstitial();
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
    }


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

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (!isPaidVersion && interstitialAd.isLoaded()) {
            interstitialAd.show();
            getJoke();
        } else {
            getJoke();
        }
    }

    private void getJoke() {
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new EndpointsAsyncTask() {
                    @Override
                    protected void onPostExecute(String joke) {
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        intent.putExtra(JOKE_EXTRA_KEY, joke);
                        startActivity(intent);

                        progressBar.setVisibility(View.GONE);
                    }
                }.execute();
            }
        }, 1500);
    }
}
