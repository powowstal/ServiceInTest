package com.postal.service;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Пора покормить кота!", Toast.LENGTH_SHORT);
        AsyncM ad = new AsyncM(getApplicationContext(), toast);
        ad.forceLoad();
        ad = null;


    }

    @Override
    protected void onStop() {
        super.onStop();
//        AsyncM ad = new AsyncM(getApplicationContext());
//        ad.forceLoad();
//        ad = null;

    }

    public class AsyncM extends AsyncTaskLoader {


        public AsyncM(Context context) {
            super(context);

        }
        Toast toast;
        public AsyncM(Context applicationContext, Toast toast) {
            super(applicationContext);
            this.toast = toast;
        }

        @Override
        public Object loadInBackground() {



            Intent par = new Intent(getApplicationContext(), MyService.class);
            startService(par);
            par = null;
            long sec = 1000*5;
            try {
                while (true) {
                    Thread.sleep(sec);
                    toast.show();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
