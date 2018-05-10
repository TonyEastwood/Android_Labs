package com.example.yourgod.lab2;

//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements Fragment2.OnFragmentInteractionListener{


    private final static String FILE_NAME = "content.txt";
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




        FileOutputStream fos = null;
        try {

            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(_text.getBytes());
            fos.write(" ".getBytes());
            fos.write(_color.getBytes());
            fos.write("\n".getBytes());

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }



    }

    public void ShowData(View view)
    {
        Intent intent = new Intent(this, DataBase.class);
        startActivity(intent);
    }
}
