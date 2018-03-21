package com.example.gaurav.pre69;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.flipboard.bottomsheet.BottomSheetLayout;

public class MainActivity extends AppCompatActivity {
    long initialTime = 0 , endTime = 0;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext=(EditText) findViewById(R.id.main_input);
        takeInput();
       /* BottomSheetLayout bottomSheet = (BottomSheetLayout) findViewById(R.id.bottomsheet);
       // Context context=MainActivity.getApplicationContext();
        bottomSheet.dismissSheet();
        Context context=this;
        bottomSheet.showWithSheetView(LayoutInflater.from(context).inflate(R.layout.my_sheet_layout, bottomSheet, false));*/
        SimpleGestureListener simpleGestureListener = new SimpleGestureListener();
        simpleGestureListener.setListener(new SimpleGestureListener.Listener() {
            @Override
            public void onScrollHorizontal(float dx) {
               // Log.i(TAG,"horizontal = " +dx);
            }

            @Override
            public void onScrollVertical(float dy) {
               // Log.i(TAG,"vertical = " +dy);
            }
        });
        //mDetector = new GestureDetector(this, simpleGestureListener);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mListener.onTouchEvent(event);
        return super.onTouchEvent(event);
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

