package com.example.bitcom.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.feezu.liuli.timeselector.TimeSelector;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TimeSelector timeSelector;
    private TextView tvshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvshow=(TextView)findViewById(R.id.tv_showtime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());

        timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                tvshow.setText(time);

            }
        }, simpleDateFormat.format(date), "2060-12-1 15:20");


        Button bt_gettime=(Button)findViewById(R.id.bt_gettime);
        bt_gettime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSelector.show();

            }
        });

    }
}
