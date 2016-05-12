package com.postal.service;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncM ad = new AsyncM(getApplicationContext());
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

        @Override
        public Object loadInBackground() {
            Intent par = new Intent(getApplicationContext(), MyService.class);
            startService(par);
            par = null;
            return null;
        }
    }
}
