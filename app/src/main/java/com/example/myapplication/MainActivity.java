package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TimeCountAPI time;
    private Button btnGetcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new TimeCountAPI(6000, 1000);
        btnGetcode=(Button) findViewById(R.id.btn_getcode);
        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.start();
            }
        });
    }
    class TimeCountAPI extends CountDownTimer {

        public TimeCountAPI(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            btnGetcode.setBackgroundColor(Color.parseColor("#DDDDDD"));
            btnGetcode.setClickable(false);
            btnGetcode.setText("("+millisUntilFinished / 1000 +") 秒后可重新点击");
        }
        @Override
        public void onFinish() {
            btnGetcode.setText("重新点击");
            btnGetcode.setClickable(true);
            btnGetcode.setBackgroundColor(Color.parseColor("#0066FF"));
//
        }
    }
}
