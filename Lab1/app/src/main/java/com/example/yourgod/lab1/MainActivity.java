package com.example.yourgod.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;


public class MainActivity extends AppCompatActivity {

    private String[] _color = {"Red", "Green", "Blue", "Black"};
    TextView text_v;
    EditText ed_text;
ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_v=(TextView) findViewById(R.id.maintext);
        ed_text= (EditText) findViewById(R.id.editText);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, _color);

        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spColor= (Spinner) findViewById(R.id.spinnerColor);

        spColor.setAdapter(colorAdapter);


        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getSelectedItem().toString()=="Red")
                    text_v.setTextColor(Color.RED);
                else if (parent.getSelectedItem().toString()=="Green")
                    text_v.setTextColor(Color.GREEN);
                else if (parent.getSelectedItem().toString()=="Blue")
                    text_v.setTextColor(Color.BLUE);
                else if (parent.getSelectedItem().toString()=="Black")
                    text_v.setTextColor(Color.BLACK);
                //Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
    }


    public void SetText(View view)
    {
        text_v.setText(ed_text.getText());
        ed_text.setText(" ");
    }
    public void CancelSetText(View view)
    {

        text_v.setText(" ");
    }
}
