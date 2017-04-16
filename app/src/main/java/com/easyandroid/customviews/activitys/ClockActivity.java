package com.easyandroid.customviews.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.easyandroid.customviews.R;
import com.easyandroid.customviews.surfaceviews.ClockView;

/**
 * package: com.easyandroid.customviews.activitys.ClockActivity
 * author: gyc
 * description:
 * time: create at 2017/4/16 17:58
 */

public class ClockActivity extends AppCompatActivity implements View.OnClickListener {
    ClockView clockView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        final TextView tv = (TextView) findViewById(R.id.tv);
        clockView = (ClockView) findViewById(R.id.clockView);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);

        clockView.setOnTimeChangeListener(new ClockView.OnTimeChangeListener() {
            @Override
            public void onTimeChange(View view, int hour, int minute, int second) {
                tv.setText(String.format("%s-%s-%s", hour, minute, second));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                clockView.setTime(11, 59, 55);
                break;
            case R.id.btn2:
                clockView.setTime(20, 30, 0);
                break;
            case R.id.btn3:
                clockView.setTime(23, 59, 55);
                break;
        }
    }
}
