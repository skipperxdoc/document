package com.example.skipperx_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.skipperx_demo.banner.BannerActivity;
import com.example.skipperx_demo.interstitial.InterstitialActivity;
import com.example.skipperx_demo.mynative.NativeActivity;
import com.example.skipperx_demo.rewarded.RewardedActivity;
import com.skipperx.sdk.SkipperXSDK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView banner = findViewById(R.id.banner);
        TextView native_ad = findViewById(R.id.native_ad);
        TextView interstitial = findViewById(R.id.interstitial);
        TextView rewarded = findViewById(R.id.rewarded);

        SkipperXSDK.initialize(getApplication(),"x_ZJAHVE8S","qk32eh51l0uks626");

        banner.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BannerActivity.class)));
        native_ad.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NativeActivity.class)));
        interstitial.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, InterstitialActivity.class)));
        rewarded.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RewardedActivity.class)));
    }
}