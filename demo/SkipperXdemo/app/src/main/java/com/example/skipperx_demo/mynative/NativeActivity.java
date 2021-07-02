package com.example.skipperx_demo.mynative;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.skipperx_demo.R;
import com.skipperx.sdk.builder.NativeAd;
import com.skipperx.sdk.callback.AdLoadListener;
import com.skipperx.sdk.callback.NativeAdLoadListener;
import com.skipperx.sdk.data.NativeData;
import com.skipperx.sdk.response.AdContent;
import com.skipperx.sdk.ui.NativeAdLayout;


public class NativeActivity extends AppCompatActivity {

    private NativeAdLayout adView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String adUnitId = "c4b3a560-dadc-11eb-a3ee-8918d8e6a624";
        setContentView(R.layout.native_full);
        NativeAd nativeAd = new NativeAd(adUnitId, this);
        nativeAd.setAdListener(new AdLoadListener() {
            @Override
            public void onAdSucLoad(AdContent adContent) {
                FrameLayout frameLayout = findViewById(R.id.my_content);
                adView = (NativeAdLayout) getLayoutInflater().inflate(R.layout.native_big_static,null);
                adView.setTitle(adView.findViewById(R.id.ad_tv_title));
                adView.setDescribe(adView.findViewById(R.id.ad_tv_desc));
                adView.setButton(adView.findViewById(R.id.ad_button));
                adView.setContainer(adView.findViewById(R.id.ad_container));
                adView.setMedia(adView.findViewById(R.id.ad_media_big));
                adView.setIcon(adView.findViewById(R.id.ad_iv_icon));
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
                adView.showAd(adContent);
            }

            @Override
            public void onAdFailLoad() {

            }
        });
        nativeAd.loadAd();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adView !=null){
            adView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView !=null){
            adView.resume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adView !=null){
            adView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView !=null){
            adView.destroy();
        }
    }
}
