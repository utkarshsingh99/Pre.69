package com.example.gaurav.pre69;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    long initialTime = 0 , endTime = 0;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext=(EditText) findViewById(R.id.main_input);
        takeInput();

    }
    private void takeInput() {
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(initialTime == 0) {
                    initialTime = System.currentTimeMillis();
                } else {
                    endTime = System.currentTimeMillis();
                    if(endTime - initialTime <=500) {
                        changeKeyboardStatus();
                    }
                    initialTime = endTime;
                }
            }
        });
    }
    private void changeKeyboardStatus() {
                edittext.setFocusable(true);
                InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}

