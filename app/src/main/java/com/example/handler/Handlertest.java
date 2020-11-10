package com.example.handler;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Handlertest extends AppCompatActivity {


    private String test;
    private TextView testView;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String test="这是线程里的文字";
                Message message=new Message();
                message.obj=test;
                message.what=1;
                handler.sendMessage(message);
            }
        }).start();
        testView=findViewById(R.id.test);
        b=findViewById(R.id.test_btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.setText(test);
            }
        });
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    test = (String) msg.obj;
                    break;
                case 2:
            }
        }
    };
}
