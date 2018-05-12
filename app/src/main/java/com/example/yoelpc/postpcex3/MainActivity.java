package com.example.yoelpc.postpcex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void asyncOnCLick(View view)
    {
        Intent intent = new Intent(this,AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void threadOnClick(View view)
    {
        Intent intent = new Intent(this,ThreadsTaskActivity.class);
        startActivity(intent);
    }
}
