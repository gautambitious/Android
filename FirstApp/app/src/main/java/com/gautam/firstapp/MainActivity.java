package com.gautam.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    Button ab;
    TextView abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ab=findViewById(R.id.button);
        abc=findViewById(R.id.textView);
    }

    public void buttonOnClick(View view) {
        abc.setText("Changed Text");
    }
}
