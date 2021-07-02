package com.example.skipperx_demo.interstitial;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.skipperx_demo.R;
import com.skipperx.sdk.builder.InterstitialAd;
import com.skipperx.sdk.callback.AdLoadListener;
import com.skipperx.sdk.callback.AdShowListener;
import com.skipperx.sdk.response.AdContent;


public class InterstitialActivity extends AppCompatActivity {
    InterstitialAd adLoader;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interstitial_center);

        String adUnitId = "d66f22c0-dadc-11eb-9328-5546c8a1c721";

        adLoader = new InterstitialAd(this);
        adLoader.setUnitId(adUnitId);
        adLoader.setAdShowListener(new AdShowListener() {
            @Override
            public void onAdShowed() {
                Log.d("INTERSTITIAL","onAdShowed");
            }

            @Override
            public boolean onAdClicked() {
                return false;
            }

            @Override
            public void onAdClosed() {

            }
        });
        adLoader.setAdListener(new AdLoadListener() {
            @Override
            public void onAdSucLoad(AdContent adContent) {
                if (adLoader.isLoaded()){
                    adLoader.showAd(InterstitialActivity.this);
                }
            }

            @Override
            public void onAdFailLoad() {

            }
        });
        adLoader.loadAd();
    }
}
