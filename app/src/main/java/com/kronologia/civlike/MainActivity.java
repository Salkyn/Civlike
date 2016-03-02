package com.kronologia.civlike;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    final Handler mHandler = new Handler();

    final IU iu = new IU();
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Activity state", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.hello_world);
        tv.setText("");


       new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        Thread.sleep(Constantes.PEON_RATE);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                iu.ville.addPeon();
                                tv.setText(iu.getJournal().toString());

                            }
                        });
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }).start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity state", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity state", "onResume");
        long end = System.currentTimeMillis();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        long start = preferences.getLong("time",0);

        long elapsed = (end - start)/1000;
        Log.d("Activity state", "Elapsed since onPause : "+elapsed+"s");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity state", "onPause");
        SharedPreferences.Editor ed = preferences.edit();
        ed.putLong("time", System.currentTimeMillis());
        ed.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity state", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity state", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity state", "onRestart");
    }

}
