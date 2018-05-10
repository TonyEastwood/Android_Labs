package com.example.yourgod.lab2;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String _text, String _color) {
        Fragment1 _fragment = (Fragment1) getSupportFragmentManager()
                .findFragmentById(R.id.fragment1);
        if (_fragment != null && _fragment.isInLayout()) {
            _fragment.setText(_text,_color);
        }
    }
}
