package com.example.yoelpc.postpcex3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    public static final int COUNT_TO = 10;
    static final long SLEEP_DURATION = 500;
    AsyncTask<Void,Integer,Void> asyncCounterTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
    }

    @SuppressLint("StaticFieldLeak")
    public void asyncCreateOnClick(View view)
    {

        asyncCounterTask = new AsyncTask<Void, Integer, Void>() {
            TextView textView = (TextView) findViewById(R.id.asyncTextView);
            @Override
            protected Void doInBackground(Void... voids) {
                for (int i =1;i<=10;i++)
                {
                    publishProgress(i);
                    try {
                        Thread.sleep(SLEEP_DURATION);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                publishProgress(11);
                return null;
            }

            protected void onProgressUpdate(Integer... progress) {
                if(progress[0]==11)
                {
                    textView.setText("Done!");
                    return;
                }
                textView.setText(progress[0].toString());
            }
        };
    }

    public void asyncStartOnClick(View view)
    {
        if(asyncCounterTask != null)
        {
            asyncCounterTask.execute();
        }
    }

    public void asyncCancelOnClick(View view)
    {
        if(asyncCounterTask != null)
        {
            asyncCounterTask.cancel(true);
        }
    }

}
