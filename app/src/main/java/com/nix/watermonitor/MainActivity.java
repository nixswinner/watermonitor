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
    private TextView mTextMessage,levelA,levelB,levelD,levelC;
    private CircleProgress circle_progressA,circle_progressB,circle_progressC,circle_progressD;
    private int waterLevelA=0,waterLevelB=0,waterLevelC=0,waterLevelD=0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("My Water Tanks Levels");
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
        levelC = (TextView) findViewById(R.id.levelC);
        levelD = (TextView) findViewById(R.id.levelD);

        circle_progressA = findViewById(R.id.circle_progressA);
        circle_progressB = findViewById(R.id.circle_progressB);
        circle_progressC = findViewById(R.id.circle_progressC);
        circle_progressD = findViewById(R.id.circle_progressD);
        waterLevelA=90;
        waterLevelB = 29;
        waterLevelC = 50;
        waterLevelD = 16;
        levelA.setText(waterLevelA+"%");
        levelB.setText(""+waterLevelB+"%");
        levelC.setText(""+waterLevelC+"%");
        levelD.setText(""+waterLevelD+"%");
        circle_progressA.setProgress(waterLevelA);
        if (waterLevelA<30){
            circle_progressA.setFinishedColor(Color.RED);
            levelA.setTextColor(Color.RED);
        }

        circle_progressB.setProgress(waterLevelB);
        if (waterLevelB<30){
            circle_progressB.setFinishedColor(Color.RED);
            levelB.setTextColor(Color.RED);
        }

        circle_progressC.setProgress(waterLevelC);
        if (waterLevelC<30){
            circle_progressC.setFinishedColor(Color.RED);
            levelC.setTextColor(Color.RED);
        }

        circle_progressD.setProgress(waterLevelD);
        if (waterLevelD<30){
            circle_progressD.setFinishedColor(Color.RED);
            levelD.setTextColor(Color.RED);

        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
