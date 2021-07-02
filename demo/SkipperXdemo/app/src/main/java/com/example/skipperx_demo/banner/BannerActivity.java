package com.example.skipperx_demo.banner;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.skipperx_demo.R;
import com.skipperx.sdk.callback.AdShowListener;
import com.skipperx.sdk.ui.BannerAdView;


public class BannerActivity extends AppCompatActivity {

    BannerAdView bannerAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_big);
        bannerAdView = findViewById(R.id.banner);
        bannerAdView.setAdUnitId("18adddd0-d979-11eb-8214-3105f20e0f87");
        bannerAdView.setAdShowListener(new AdShowListener() {
            @Override
            public void onAdShowed() {

            }

            @Override
            public boolean onAdClicked() {
                return false;
            }

            @Override
            public void onAdClosed() {

            }
        });
        bannerAdView.loadAd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerAdView.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerAdView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bannerAdView.destroy();
    }
}
