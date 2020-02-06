package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.fragmenttest.fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP)
            jumpFirstFragment();
        return super.onTouchEvent(event);
    }

    FirstFragment firstFragment;

    private void jumpFirstFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (firstFragment == null) {
            firstFragment = new FirstFragment();
            ft.add(R.id.content, firstFragment);
          ft.addToBackStack(firstFragment.getClass().getName());//添加到回退栈中
        }else {
            ft.attach(firstFragment);
        }

        ft.commit();

    }

    @Override
    public void onBackPressed() {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.detach(firstFragment);
//        ft.commit();
        super.onBackPressed();
    }
}
