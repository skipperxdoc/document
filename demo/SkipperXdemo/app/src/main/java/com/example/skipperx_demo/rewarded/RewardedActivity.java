package com.example.skipperx_demo.rewarded;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.skipperx_demo.R;
import com.skipperx.sdk.builder.RewardedAd;
import com.skipperx.sdk.callback.AdLoadListener;
import com.skipperx.sdk.callback.RewardedAdCallback;
import com.skipperx.sdk.response.AdContent;

import java.util.HashMap;
import java.util.Map;

public class RewardedActivity extends AppCompatActivity {
    RewardedAd rewardedAd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rewarded_test);
        Map<String, String> map = new HashMap<>();
        map.put("customer_id", "1234567");
        map.put("unique_id", "uihj89uijkbn7uy8");
        map.put("reward_type", "add_coins");
        map.put("reward_value", "2");
        map.put("verifier", "tyuidjkol");
        map.put("extinfo", "{'self define':'xxx'}");
        rewardedAd = new RewardedAd(this);
        rewardedAd.setAdUnitId("f4132dd0-dadc-11eb-a3ee-8918d8e6a624");
        rewardedAd.setRequestParams(map);
        AdLoadListener adLoadCallBack = new AdLoadListener() {
            @Override
            public void onAdSucLoad(AdContent adContent) {
                Log.d("REWARDED111", "onAdSucLoad");
                rewardedAd.showAd(RewardedActivity.this);
            }

            @Override
            public void onAdFailLoad() {
                Log.d("REWARDED111", "onAdFailLoad");
            }
        };
        rewardedAd.setAdListener(adLoadCallBack);
        rewardedAd.loadAd();
        RewardedAdCallback adCallback = new RewardedAdCallback() {
            @Override
            public void onRewardedAdOpened() {
                Log.d("REWARDED111", "onRewardedAdOpened");
            }

            @Override
            public void onRewardedAdClosed() {
                Log.d("REWARDED111", "onRewardedAdClosed");
            }

            @Override
            public void onUserEarnedReward() {
                Log.d("REWARDED111", "onUserEarnedReward");
            }

            @Override
            public void onRewardedAdFailedToShow() {
                Log.d("REWARDED111", "onRewardedAdFailedToShow");
            }

            @Override
            public boolean onAdClicked() {
                Log.d("REWARDED111", "onAdClicked");
                return false;
            }
        };
        rewardedAd.setRewardedAdCallback(adCallback);
    }
}
