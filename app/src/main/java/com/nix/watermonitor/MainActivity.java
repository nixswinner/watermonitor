package com.nix.watermonitor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage,levelA,levelB;
    private CircleProgress circle_progressA,circle_progressB;
    private int waterLevelA=0,waterLevelB=0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        levelA = (TextView) findViewById(R.id.levelA);
        levelB = (TextView) findViewById(R.id.levelB);
        circle_progressA = findViewById(R.id.circle_progressA);
        circle_progressB = findViewById(R.id.circle_progressB);
        waterLevelA=90;
        waterLevelB = 29;
        levelA.setText(waterLevelA+"%");
        levelB.setText(""+waterLevelB+"%");
        circle_progressA.setProgress(waterLevelA);
        if (waterLevelA<30){
            circle_progressA.setFinishedColor(Color.RED);
        }
        circle_progressB.setProgress(waterLevelB);
        if (waterLevelB<30){
            circle_progressB.setFinishedColor(Color.RED);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
