package com.example.yoelpc.postpcex3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ThreadsTaskActivity extends AppCompatActivity {
    public static final int COUNT_TO = 10;
    static final long SLEEP_DURATION = 500;
    private Thread thread;
    TextView textView1;

    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message message) {
            textView1.setText(message.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads_task);
    }


    public void createOnClick(View view) {

        textView1 = findViewById(R.id.ThreadsTextView);
        thread = new Thread(new Runnable() {

            final TextView textView = textView1;
            @SuppressLint("SetTextI18n")
            public void run() {
//


                String newText="";
                for (int i = 1; i < COUNT_TO; i++) {
                    newText += i+"\n";
                    Message message = mHandler.obtainMessage(1,newText);
                    message.sendToTarget();

                    try {
                        Thread.sleep(SLEEP_DURATION);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Message message = mHandler.obtainMessage(1,newText+"Done");
                message.sendToTarget();
            }
        });
    }

    public void startOnClick(View view) {
//        runOnUiThread(thread);
        thread.start();
    }

    public void cancelOnClick(View view) {
        if (thread != null) {
            thread.interrupt();
        }
    }

}
