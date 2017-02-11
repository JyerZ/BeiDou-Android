package com.zjyzbfxgqzh.beidou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Jyer Z on 2016/4/15.
 */
public class WelcomeActivity extends Activity {
    private Handler mHandler = new Handler();

    ImageView welcomeImg;
    TextView textview;
    int alpha = 255;
    int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_main);
        welcomeImg = (ImageView) this.findViewById(R.id.welcome_img);
        textview = (TextView) this.findViewById(R.id.welcome);
        welcomeImg.setAlpha(alpha);
        new Thread(new Runnable() {
            public void run() {
                while (b < 2) {
                    try {
                        if (b == 0) {
                            Thread.sleep(200);
                            b = 1;
                        } else {
                            Thread.sleep(50);
                        }
                        updateApp();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                welcomeImg.setAlpha(alpha);
                welcomeImg.invalidate();
            }
        };
    }
    public void updateApp() {
        alpha -= 5;
        if (alpha <= 0) {
            b = 2;
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            finish();
        }
        mHandler.sendMessage(mHandler.obtainMessage());
    }
}
