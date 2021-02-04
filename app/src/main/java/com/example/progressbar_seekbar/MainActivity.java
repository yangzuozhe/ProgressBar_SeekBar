package com.example.progressbar_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar sbSeekBar;
    TextView tvSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sbSeekBarFun();
        ratingBarFun();
    }

    /**
     * 这是拖动条的方法
     */
    public void sbSeekBarFun() {
        sbSeekBar = findViewById(R.id.sbSeekBar);
        tvSeekBar = findViewById(R.id.tvSeekBar);
        sbSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * 进度发生改变时会触发
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekBar.setText("当前的进度值为" + progress + "/100");
            }

            /**
             * 按住SeekBar时会触发
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.getContext(), "按住了seekbar", Toast.LENGTH_SHORT).show();
            }

            /**
             * 放开SeekBar时触发
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.getContext(), "放开了seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 评价按钮的监听事件
     */
    public void ratingBarFun() {
        RatingBar rbStart = findViewById(R.id.rbStart);
        rbStart.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "rating:" + String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }

}